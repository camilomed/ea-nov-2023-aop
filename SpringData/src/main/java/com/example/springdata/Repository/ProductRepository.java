package com.example.springdata.Repository;

import com.example.springdata.Entity.Category;
import com.example.springdata.Entity.Product;
import com.example.springdata.Entity.Review;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends ListCrudRepository<Product,Long> {
    List<Product>findAllByPriceIsGreaterThan(double price);
    List<Product>findAllByCategoryAndPriceLessThan(Category category,double price);
    List<Product>findAllByNameContaining(String name);

}
