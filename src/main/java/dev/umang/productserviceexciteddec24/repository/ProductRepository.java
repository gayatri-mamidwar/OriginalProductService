package dev.umang.productserviceexciteddec24.repository;

import dev.umang.productserviceexciteddec24.models.Product;
import dev.umang.productserviceexciteddec24.projections.ProductWithIdAndPriceProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    List<Product> findAll();

    /* pagination- by JPA repository
     //from which limit and which offset you need to fetch?
    //pageNo = 20, pageSize = 25
    //pageNo starts from 0 20*25 = 500 retrieved earlier
    //20th page will show 501th to 526th products
     */
    @Override
    Page<Product> findAll(Pageable pageable); //pageNo, pageSize - data will given from the fronted

    Product save(Product p);

    @Override
    Optional<Product> findById(Long id);

    /*
        JPA declared queries with format. no need to write custom query in this-
        List<Product> findAllByCategory_title(String title);
        List<Product> findAllByCategory_id(Long id);
    */

    /*
        HQL query same like sql but uses OOP-
        @Query("select p.id, p.price from Product p where p.category.title =:title")
        List<ProductWithIdAndPriceProjection> getAllProductIdAndPriceFromGivenCategory(String title);

     */

    /*
        Native SQL query. needs value and nativeQuery = true attributes.
        "categoryTitle" any random name we can give in query & param.
        in below query '+' is used just for concatination. u can write sql query in 1 line also without '+'
    */
        @Query(value = "SELECT p.id AS id, p.price AS price " +
            "FROM product p " +
            "JOIN category c ON p.category_id = c.id " +
            "WHERE c.title = :categoryTitle", nativeQuery = true)
        List<ProductWithIdAndPriceProjection> getIdAndPricesOfAllProductsWithGivenTitle(@Param("categoryTitle") String categoryTitle);
}

/* Projection-
if you are taking returntype as projection class name then in @query select only that cols which are mentioned in projection.
If u take select * then it will throw error.i.e Modify the query to explicitly select only the columns needed by the projection.
 */

/* We don't have complete control over the query that JPA will execute for us?
    I am interested only in certain columns. I'll provide the query?
    HQL - Similar to SQL but with a small pinch of OOP.
     */

    /* Providing the query to JPA can be done :-
    1. HQL
    2. Native SQL
     */