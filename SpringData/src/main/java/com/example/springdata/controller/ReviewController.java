package com.example.springdata.controller;

import com.example.springdata.Entity.Review;
import com.example.springdata.Service.ReviewServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Review")
public class ReviewController {

    @Autowired
    private ReviewServiceImp ReviewServiceImp;
    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody Review Review){
        this.ReviewServiceImp.saveReview(Review);
        return new ResponseEntity<>(Review, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReview(){
        List<Review> reviews = this.ReviewServiceImp.getAllReview();
        return new ResponseEntity<>(reviews,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReview(@PathVariable long id){
        Review Review = this.ReviewServiceImp.getReviewById(id);
        return  new ResponseEntity<>(Review,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Review> deleteReview(@PathVariable long id){
        if(this.ReviewServiceImp.getReviewById(id)==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Review ReviewDeleted = this.ReviewServiceImp.getReviewById(id);
        this.ReviewServiceImp.deleteReview(id);
        return new ResponseEntity<>(ReviewDeleted,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable long id,@RequestBody Review Review){
        if(this.ReviewServiceImp.getReviewById(id)==null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(id!=Review.getId()){
            return  new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        this.ReviewServiceImp.saveReview(Review);
        return  new ResponseEntity<>(Review,HttpStatus.OK);
    }
    @GetMapping("/productId/{id}")
    public ResponseEntity<List<Review>>  findAllByProduct_Id (@PathVariable long id){
        List<Review> reviews = this.ReviewServiceImp.findAllByProduct_Id(id);
        return  new ResponseEntity<>(reviews,HttpStatus.OK);
    }
}
