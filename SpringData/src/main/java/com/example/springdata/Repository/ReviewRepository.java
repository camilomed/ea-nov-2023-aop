package com.example.springdata.Repository;

import com.example.springdata.Entity.Review;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository  extends ListCrudRepository<Review,Long> {
    List<Review> findAllByProduct_Id(long id);
}
