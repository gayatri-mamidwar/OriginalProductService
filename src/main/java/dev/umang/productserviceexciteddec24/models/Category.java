package dev.umang.productserviceexciteddec24.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Category extends BaseModel{
    private String title;

    //duplicate relation(already mentioned in product class) we are showing with the help of 'mappedBy' param
    // CascadeType.REMOVE -> if any category is deleted then remove all products associated with that category
    @OneToMany(mappedBy = "category", cascade = {CascadeType.REMOVE})
    @JsonIgnore
    private List<Product> products; //electronics

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}


/* Some common attributes mentioned in BaseModel

id,
createdAt,
lastModified
 */