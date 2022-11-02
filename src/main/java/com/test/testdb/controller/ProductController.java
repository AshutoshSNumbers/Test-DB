package com.test.testdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.testdb.model.Product;
import com.test.testdb.services.ProductService;


@RestController
public class ProductController {

    @Autowired
    ProductService prodService;


    @GetMapping(value="/")
    public String test(){
        return "Hello World!";
    }

    @GetMapping(value = "/products")
    public List<Product> getProducts() {
        return prodService.getAllProducts();
    }

    @GetMapping(value = "/product:{productId}")
    public Product getProductById(@PathVariable("productId") Long productId) {
        return prodService.getProductsById(productId);
    }

    @PostMapping(value = "/product")
    public String addProduct(@RequestBody Product product){
        return prodService.addProduct(product);
    }

    @PutMapping(value = "/product")
    public String updateProduct(@RequestBody Product product){
        return prodService.updateProduct(product);
    }

    @DeleteMapping(value = "/product:{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId){
        return prodService.deleteProduct(productId);
    }

}
