package com.example.springintegrationlearning.service;

import com.example.springintegrationlearning.model.Product;

public interface ProductService {

    Product getProductById(long id);

    Product createProduct(Product product);
}
