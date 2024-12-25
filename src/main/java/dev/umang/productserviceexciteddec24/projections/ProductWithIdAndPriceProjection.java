package dev.umang.productserviceexciteddec24.projections;

public interface ProductWithIdAndPriceProjection {

    long getId();
    double getPrice();
}

/*
Projections in Spring Data JPA rely on matching the property names in the interface to the column names returned by the query.
Your projection expects id and price. Ensure these column names exist in the database and match the query.
 */