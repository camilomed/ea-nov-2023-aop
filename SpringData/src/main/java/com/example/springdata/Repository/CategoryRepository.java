package com.example.springdata.Repository;

import com.example.springdata.Entity.Category;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface CategoryRepository extends ListCrudRepository<Category,Long> {
}
