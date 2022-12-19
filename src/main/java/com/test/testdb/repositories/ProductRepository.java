package com.test.testdb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.testdb.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    @Query("{productId :?0}")
    Product findByProductId(Long productId);
}
