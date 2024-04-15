package com.example.springdata.controller;

import com.example.springdata.Entity.Category;
import com.example.springdata.Entity.Product;
import com.example.springdata.Service.ProductService;
import com.example.springdata.Service.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceImp productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = this.productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductByID(@PathVariable long id){
        Product product = this.productService.getProductById(id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product newProduct = this.productService.saveProduct(product);
        return new ResponseEntity<>(newProduct,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> editProduct(@PathVariable long id,Product product){
        if(this.productService.getProductById(id)==null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Product updateProduct = this.productService.saveProduct(product);
        return  new ResponseEntity<>(updateProduct,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable long id){
        if(this.productService.getProductById(id)==null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        Product deleteProduct = this.productService.getProductById(id);
        this.productService.deleteProduct(id);
        return  new ResponseEntity<>(deleteProduct,HttpStatus.OK);
    }

    @GetMapping("/costGreater/{price}")
    public ResponseEntity<List<Product>> findAllByPriceIsGreaterThan(@PathVariable double price){
       List<Product> products= this.productService.findAllByPriceIsGreaterThan(price);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
    @GetMapping("/categoryAndPrice/{price}")
    public ResponseEntity<List<Product>> findAllByCategoryAndPriceLessThan(@PathVariable double price, @RequestBody Category category){
        List<Product> products= this.productService.findAllByCategoryAndPriceLessThan(category,price);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
    @GetMapping("/nameContain/{name}")
    public ResponseEntity<List<Product>> findAllByName(@PathVariable String name){
        List<Product> products= this.productService.findAllByNameContaining(name);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
}
