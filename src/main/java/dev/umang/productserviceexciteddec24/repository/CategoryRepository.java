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

    //JPA methods => Declared queries
    Category findByTitle(String title);

    // HQL/custom query
    @Query("SELECT p FROM Product p WHERE p.category.title = :title")
    List<Product> findProductsByTitle(@Param("title") String title);

    // declared queries
    //@Override
    List<Category> findAll();

}

/* wrong way we need custom query-
List<Product> findProductsByTitle(String title);


JPA selects all the columns & if want to select only some columns then write HQL query.
Projections are nothing but interface.
 */
