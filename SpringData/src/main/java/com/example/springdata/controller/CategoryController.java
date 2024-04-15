package com.example.springdata.controller;

import com.example.springdata.Entity.Category;
import com.example.springdata.Service.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Category")
public class CategoryController {

    @Autowired
    private CategoryServiceImp CategoryServiceImp;
    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category Category){
        this.CategoryServiceImp.saveCategory(Category);
        return new ResponseEntity<>(Category, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> Categories = this.CategoryServiceImp.getAllCategory();
        return new ResponseEntity<>(Categories,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable long id){
        Category Category = this.CategoryServiceImp.getCategoryById(id);
        return  new ResponseEntity<>(Category,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable long id){
        if(this.CategoryServiceImp.getCategoryById(id)==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Category CategoryDeleted = this.CategoryServiceImp.getCategoryById(id);
        this.CategoryServiceImp.deleteCategory(id);
        return new ResponseEntity<>(CategoryDeleted,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable long id,@RequestBody Category Category){
        if(this.CategoryServiceImp.getCategoryById(id)==null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(id!=Category.getId()){
            return  new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        this.CategoryServiceImp.saveCategory(Category);
        return  new ResponseEntity<>(Category,HttpStatus.OK);
    }
}
