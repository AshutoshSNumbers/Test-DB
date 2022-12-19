package com.test.testdb.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.test.testdb.exceptions.FailedDBMethodException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.testdb.model.Product;
import com.test.testdb.repositories.ProductRepository;

@Service
public class ProductService implements IProductService{

    @Autowired
    ProductRepository prodRepo;
    
    public List<Product> getAllProducts(){
        return prodRepo.findAll();
    }

    public Product getProductById(Long productId) {
        Product product = prodRepo.findByProductId(productId);
        if(product != null){
            return product;
        }
        throw new NoSuchElementException();

    }

    public Product addProduct(Product product){
        try{
            prodRepo.insert(product);
            return product;
        }catch(Exception e){
            throw new FailedDBMethodException();
        }
    }

    public Product deleteProduct(Long productId){
        Product product = this.getProductById(productId);
        prodRepo.delete(product);
        try{
            prodRepo.delete(product);
            return product;
        }catch(Exception e){
            throw new FailedDBMethodException();
        }
    }

    public Product updateProduct(Product product){
        try{
            Product prod= prodRepo.save(product);
            return prod;
        }catch(Exception e){
            throw new FailedDBMethodException();
        }
    }

}
