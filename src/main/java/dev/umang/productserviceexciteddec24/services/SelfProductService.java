package dev.umang.productserviceexciteddec24.services;

import dev.umang.productserviceexciteddec24.dtos.CreateProductRequestDto;
import dev.umang.productserviceexciteddec24.dtos.SelfResponseDto;
import dev.umang.productserviceexciteddec24.exceptions.ProductNotFoundException;
import dev.umang.productserviceexciteddec24.models.Category;
import dev.umang.productserviceexciteddec24.models.Product;
import dev.umang.productserviceexciteddec24.repository.CategoryRepository;
import dev.umang.productserviceexciteddec24.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException{

        Optional<Product> optionalproduct = productRepository.findById(id);

        if(optionalproduct.isEmpty()){
            //product with given id doesn't exist
            throw new ProductNotFoundException("Product with given id doesn't exist");
        }

        return optionalproduct.get();   //Optional cls get() either return null(if not present), product(if present)
    }

    //get all products from product table
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }



    /* WHen sending direct DTO-
    @Override
    public Product createProduct(CreateProductRequestDto createProductRequestDto) {

        SelfResponseDto selfResponseDto = new SelfResponseDto();

        selfResponseDto.setTitle(createProductRequestDto.getTitle());
        selfResponseDto.setDescription(createProductRequestDto.getDescription());
        selfResponseDto.setImage(createProductRequestDto.getImage());
        selfResponseDto.setCategory(createProductRequestDto.getCategory());
        selfResponseDto.setPrice(createProductRequestDto.getPrice());

        Product product = productRepository.save(selfResponseDto.toProduct());
        return product;
    }
    */

    @Override
    public Product createProduct(String title, String description, String image, String category, double price) {
        Product product = new Product();

        product.setTitle(title);
        product.setDescription(description);
        product.setImageUrl(image);
        product.setPrice(price);

        Category categoryFromDb = categoryRepository.findByTitle(category);

        if(categoryFromDb == null){
            Category newCategory = new Category();
            newCategory.setTitle(category);
            product.setCategory(newCategory);

            //if Category is null & you want to save it in Category table 1st before creating product, then use below line
            // categoryRepository.save(newCategory);
        }
        else{
            product.setCategory(categoryFromDb);
        }

        Product createdProduct = productRepository.save(product);
        return createdProduct;
    }
}
