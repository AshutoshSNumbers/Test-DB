package com.test.testdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getProducts() {
        return new ResponseEntity<List<Product>>(prodService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping(value = "/product:{productId}")
    public ResponseEntity<?>  getProductById(@PathVariable("productId") Long productId) {
        return new ResponseEntity<Product>(prodService.getProductById(productId), HttpStatus.OK);
    }

    @PostMapping(value = "/product")
    public ResponseEntity<?>  addProduct(@RequestBody Product product){
        return new ResponseEntity<Product>(prodService.addProduct(product), HttpStatus.OK);
    }

    @PutMapping(value = "/product")
    public ResponseEntity<?>  updateProduct(@RequestBody Product product){
        return new ResponseEntity<Product>(prodService.updateProduct(product), HttpStatus.OK);
    }

    @DeleteMapping(value = "/product:{productId}")
    public ResponseEntity<?>  deleteProduct(@PathVariable("productId") Long productId){
        return new ResponseEntity<Product>(prodService.deleteProduct(productId), HttpStatus.OK);
    }

}
