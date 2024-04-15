package com.example.springdata.Service;

import com.example.springdata.Entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product saveProduct(Product product);
    void  deleteProduct(long id);
}

