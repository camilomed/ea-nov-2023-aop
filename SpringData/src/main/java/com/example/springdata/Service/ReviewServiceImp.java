package com.example.springdata.Service;


import com.example.springdata.Entity.Category;
import com.example.springdata.Entity.Review;
import com.example.springdata.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImp implements ReviewService{

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReview() {
        return this.reviewRepository.findAll();
    }

    @Override
    public Review getReviewById(long id) {
        return this.reviewRepository.findById(id).get();
    }

    @Override
    public Review saveReview(Review review) {
        return this.reviewRepository.save(review);
    }

    @Override
    public void deleteReview(long id) {
        this.reviewRepository.deleteById(id);
    }


    public List<Review> findAllByProduct_Id (long id){
        return this.reviewRepository.findAllByProduct_Id(id);
    }
}
