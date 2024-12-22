package dev.umang.productserviceexciteddec24.services;

import dev.umang.productserviceexciteddec24.dtos.CreateProductRequestDto;
import dev.umang.productserviceexciteddec24.models.Product;

import java.util.List;
import java.util.Optional;

//Interface - like a contract
public interface ProductService {

    Product getSingleProduct(long id);

    List<Product> getAllProducts();

//    sending direct DTO from controller to service is not a good practice. like below
//    Product createProduct(CreateProductRequestDto createProductRequestDto);

    Product createProduct(String title, String description, String image, String category, double price);

}

/*
Client - Controller - Service
 */
