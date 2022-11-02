package com.test.testdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.test.testdb.model.Product;
import com.test.testdb.repositories.ProductRepository;

@SpringBootApplication
public class TestdbApplication implements CommandLineRunner{
	private final ProductRepository productRepository;

	@Autowired
	public TestdbApplication(ProductRepository productRepository){
		this.productRepository = productRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(TestdbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		if(productRepository.findAll().isEmpty()) {
			productRepository.save(new Product());
		}
		
	}

}
