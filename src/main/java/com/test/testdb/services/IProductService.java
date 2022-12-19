package com.test.testdb.services;

import com.test.testdb.model.Product;

import java.util.List;

public interface IProductService {
    public List<Product> getAllProducts();
    public Product addProduct(Product product);
    public Product deleteProduct(Long productId);
    public Product updateProduct(Product product);
}
