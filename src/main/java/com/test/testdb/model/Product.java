package com.test.testdb.model;

import lombok.Getter;
import lombok.Setter;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter @Setter @Document(collection = "products")
public class Product {
    private ObjectId _id;
    private Long productId;
    private String category;
    private String subCategory;
    private String displayName;
    private String description;
    private Double listPrice;
    private Double salePrice;
    private String uom;
    private String brand;
    private String sku;
    private Long hsn;
    private String taxGroup;
    private String imageUrl;
}

