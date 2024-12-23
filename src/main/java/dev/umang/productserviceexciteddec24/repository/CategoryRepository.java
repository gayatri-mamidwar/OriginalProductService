package dev.umang.productserviceexciteddec24.repository;

import dev.umang.productserviceexciteddec24.models.Category;
import dev.umang.productserviceexciteddec24.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByTitle(String title);

    @Query("SELECT p FROM Product p WHERE p.category.title = :title")
    List<Product> findProductsByTitle(@Param("title") String title);

//    @Override
    List<Category> findAll();
}

/* wrong way we need custom query-
List<Product> findProductsByTitle(String title);
 */