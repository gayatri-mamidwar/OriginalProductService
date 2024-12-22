package dev.umang.productserviceexciteddec24.dtos;

import dev.umang.productserviceexciteddec24.models.Category;
import dev.umang.productserviceexciteddec24.models.Product;

public class SelfResponseDto {

    private long id;
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //Method to convert SelfResponseDto to Product. whatever values we are getting setting in product hence set() used
    public Product toProduct() {
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);

        Category category1 = new Category();
        category1.setTitle(category);           //in this cls, category is of String type.nd inside Product, category is obj type so creating category1 obj
        product.setCategory(category1);

        product.setDescription(description);
        product.setImageUrl(image);

        return product;
    }
}
