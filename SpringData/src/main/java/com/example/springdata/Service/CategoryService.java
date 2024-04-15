package com.example.springdata.Service;

import com.example.springdata.Entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();
    Category getCategoryById(long id);
    Category saveCategory(Category Category);
    void  deleteCategory (long id);
}
