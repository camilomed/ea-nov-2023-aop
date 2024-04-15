package com.example.springdata.Service;

import com.example.springdata.Entity.Category;
import com.example.springdata.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService{
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategory() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(long id) {
        return this.categoryRepository.findById(id).get();
    }

    @Override
    public Category saveCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(long id) {
        this.categoryRepository.deleteById(id);

    }
}
