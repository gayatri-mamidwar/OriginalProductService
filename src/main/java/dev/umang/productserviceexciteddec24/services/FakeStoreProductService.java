package dev.umang.productserviceexciteddec24.services;

import dev.umang.productserviceexciteddec24.dtos.CreateProductRequestDto;
import dev.umang.productserviceexciteddec24.dtos.FakeStoreProductDTO;
import dev.umang.productserviceexciteddec24.exceptions.ProductNotFoundException;
import dev.umang.productserviceexciteddec24.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;
    private RedisTemplate redisTemplate;

    public FakeStoreProductService(RestTemplate restTemplate, RedisTemplate redisTemplate){
        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Product getSingleProduct(long id) {
        System.out.println("Debugging 1");
        //Is is to going to fetch product from fakestore?
        /*
        Check for the product with this id in the cache??
        if present, return, else go to db and fetch
         */

        Product cachedProduct =  (Product)redisTemplate.opsForHash().get("Products", "Product_" + id);

        if(cachedProduct != null){
            /*
            cache hit
             */
            return cachedProduct;
        }

        /*
         * cache miss
         */
        ResponseEntity<FakeStoreProductDTO> fakeStoreProductDTOResponse = restTemplate.getForEntity("https://fakestoreapi.com/products/" + id,
                FakeStoreProductDTO.class);

        Product response = fakeStoreProductDTOResponse.getBody().toProduct();

        // before returning result store in redis Hash
        redisTemplate.opsForHash().put("Products", "Product_" + id, response);

        return response;
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDTO[] fakeStoreProductDTOS = restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDTO[].class);

        List<Product> products = new ArrayList<>();

        for(FakeStoreProductDTO fakeStoreProductDTO: fakeStoreProductDTOS){
            products.add(fakeStoreProductDTO.toProduct());
        }

        return products;
    }

    @Override
    public Page<Product> getPaginatedProducts(int pageNo, int pageSize) {
        return null;
    }

    @Override
    public void deleteProduct(long id) throws ProductNotFoundException {

    }


    @Override
    public Product createProduct(String title, String description, String image, String category, double price) {
        return null;
    }

}
