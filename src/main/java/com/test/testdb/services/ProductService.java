package com.test.testdb.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.testdb.model.Product;
import com.test.testdb.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository prodRepo;
    
    public List<Product> getAllProducts(){
       try{
           return prodRepo.findAll();
       }catch(Exception e){
           return new ArrayList<>();
       }
    }

    public Product getProductsById(Long productId){
        try{
            List<Product> products = prodRepo.findByProductId(productId);
                return products.get(0);

        }catch(Exception e){
            return new Product();
        }
    }

    public String addProduct(Product product){
        try{
            prodRepo.insert(product);
            return "Successfully added product : " + String.valueOf(product);
        }catch(Exception e){
            return "Unable to add the product with productId : " + String.valueOf(product) ;
        }
    }

    public String deleteProduct(Long productId){
        try{
            List<Product> products = prodRepo.findByProductId(productId);
            if(products.size() > 0){
                prodRepo.delete(products.get(0));
            }
            return "Deleted product : " + products.get(0).toString();
        }catch(Exception e){
            return "Unable to delete the product with productId : " + productId;
        }
    }

    public String updateProduct(Product product){
        try{
            Product prod= prodRepo.save(product);
            return "Product updated : " + String.valueOf(prod);
        }catch(Exception e){
            return "Unable to update the product : " + String.valueOf(product);
        }
    }

}
