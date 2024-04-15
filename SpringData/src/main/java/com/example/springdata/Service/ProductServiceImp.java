package com.example.springdata.Service;

import com.example.springdata.Entity.Category;
import com.example.springdata.Entity.Product;
import com.example.springdata.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return this.productRepository.findById(id).get();
    }

    @Override
    public Product saveProduct(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public void deleteProduct(long id) {

        this.productRepository.deleteById(id);
    }

    public List<Product> findAllByPriceIsGreaterThan(double price){
        return     this.productRepository.findAllByPriceIsGreaterThan(price);
    }
    public List<Product>findAllByCategoryAndPriceLessThan(Category category,double price){
        return this.productRepository.findAllByCategoryAndPriceLessThan(category,price);
    }

    public List<Product>findAllByNameContaining(String name){
        return  this.productRepository.findAllByNameContaining(name);
    }
}
