package dev.umang.productserviceexciteddec24.services;

import dev.umang.productserviceexciteddec24.dtos.CreateProductRequestDto;
import dev.umang.productserviceexciteddec24.exceptions.ProductNotFoundException;
import dev.umang.productserviceexciteddec24.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

//Interface - like a contract
public interface ProductService {

    Product getSingleProduct(long id) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Page<Product> getPaginatedProducts(int pageNo, int pageSize);

    void deleteProduct(long id) throws  ProductNotFoundException;

//    sending direct DTO from controller to service is not a good practice. like below
//    Product createProduct(CreateProductRequestDto createProductRequestDto);

    Product createProduct(String title, String description, String image, String category, double price);

}

/*
Client - Controller - Service
 */
