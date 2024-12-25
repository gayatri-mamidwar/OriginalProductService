package dev.umang.productserviceexciteddec24.controllers;

import dev.umang.productserviceexciteddec24.dtos.CreateProductRequestDto;
import dev.umang.productserviceexciteddec24.exceptions.ProductNotFoundException;
import dev.umang.productserviceexciteddec24.models.Category;
import dev.umang.productserviceexciteddec24.models.Product;
import dev.umang.productserviceexciteddec24.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    //Contructor injection
    /* IF only 1 service class is there, no need of @Qualifier annotation
    public ProductController(ProductService productService){
        this.productService = productService;
    }
     */

    // If more than 1 service class is there, then to know spring which obj to use, @Qualifier is required
    public ProductController(@Qualifier("selfProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") long id) throws ProductNotFoundException {
        return productService.getSingleProduct(id);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    /* DO NOT SEND direct DTO from controller to service. always extract info from DTO in controller then send that info
    to service. This is just for validation logic purpose at controller side. business logic will be in service class
    public Product createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
        return productService.createProduct(createProductRequestDto);
    }
     */

    //Product obj is a obj from db. which is already created

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
        return productService.createProduct(createProductRequestDto.getTitle(), createProductRequestDto.getDescription(),
                createProductRequestDto.getImage(), createProductRequestDto.getCategory(), createProductRequestDto.getPrice());
    }

    //productService.createProduct
    //productService.getAllProducts
}
