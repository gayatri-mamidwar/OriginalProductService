package dev.umang.productserviceexciteddec24.services;

import dev.umang.productserviceexciteddec24.models.Category;
import dev.umang.productserviceexciteddec24.models.Product;
import dev.umang.productserviceexciteddec24.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("selfCategoryService")
public class SelfCategoryService implements CategoryService{

    private CategoryRepository categoryRepository;

    public SelfCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<String> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<String> categoryNames = new ArrayList<>();

        for(Category c : categories){
            categoryNames.add(c.getTitle());
        }

        return categoryNames;
    }

    @Override
    public List<Product> getAllProductsByTitle(String title) {
        return categoryRepository.findProductsByTitle(title);
    }

    /*
    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }
     */
}
