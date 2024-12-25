package dev.umang.productserviceexciteddec24;

import dev.umang.productserviceexciteddec24.models.Product;
import dev.umang.productserviceexciteddec24.projections.ProductWithIdAndPriceProjection;
import dev.umang.productserviceexciteddec24.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductServiceExcitedDec24ApplicationTests {


    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    //JPA declared query test case
//    @Test
//    void testCategoryRepository(){
//        List<Product> products = productRepository.findAllByCategory_title("jewelery");
//        System.out.println(products);
//    }

    //HQl query test case using projection interface. to select only some columns instead of all
//    @Test
//    void testProjection(){
//       List<ProductWithIdAndPriceProjection> projections= productRepository.getAllProductIdAndPriceFromGivenCategory("jewelery");
//        System.out.println(projections);
//    }

    //SQL native query test case using projection as return type
//    @Test
//    void testNativeQuery(){
//        List<ProductWithIdAndPriceProjection> projections = productRepository.getIdAndPricesOfAllProductsWithGivenTitle("jewelery");
//        System.out.println(projections);
//    }
}
