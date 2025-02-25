package dev.umang.productserviceexciteddec24.controllers;

import dev.umang.productserviceexciteddec24.models.Category;
import dev.umang.productserviceexciteddec24.models.Product;
import dev.umang.productserviceexciteddec24.services.CategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(@Qualifier("selfCategoryService") CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /* GET ALL CATEGORIES with PRODUCT details
    @GetMapping("/products/categories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }
     */

    // GET list of products by category title
    @GetMapping("/products/category/{title}")
    public List<Product> getSingleCategory(@PathVariable("title") String title){
        return categoryService.getAllProductsByTitle(title);
    }

    // Get list of categories as List of string
    @GetMapping("/products/categories")
    public List<String> getAllCategories(){
        return categoryService.getAllCategories();
    }
}
