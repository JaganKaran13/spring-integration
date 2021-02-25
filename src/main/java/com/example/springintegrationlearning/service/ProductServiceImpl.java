package com.example.springintegrationlearning.service;

import com.example.springintegrationlearning.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getProductById(long id) {
        if(id == 1) {
            return new Product(id, "Get Product");
        } else {
            return null;
        }
    }

    @Override
    public Product createProduct(Product product) {
        return new Product(2,"New Product");
    }
}
