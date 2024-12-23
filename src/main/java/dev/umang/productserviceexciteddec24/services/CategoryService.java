package dev.umang.productserviceexciteddec24.services;

import dev.umang.productserviceexciteddec24.models.Category;
import dev.umang.productserviceexciteddec24.models.Product;

import java.util.List;

public interface CategoryService {

//    List<Category> getAllCategories();
    List<String> getAllCategories();

    List<Product> getAllProductsByTitle(String title);
}


/* IMP-
List<String> ==>> To return all category titles present in category table
List<Category> ==>> To return Category Object which include everything about category i.e
                    How many products comes under that category
                    Category details as well as product details.

   AS PER FAKESTOREAPI /products/categories API RETURNS CATEGORY TITLE ARRAY. HENCE USING LIST<STRING>

 */