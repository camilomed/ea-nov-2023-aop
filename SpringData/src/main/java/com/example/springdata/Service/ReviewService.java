package com.example.springdata.Service;

import com.example.springdata.Entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReview();
    Review getReviewById(long id);
    Review saveReview(Review Review);
    void  deleteReview (long id);
}
