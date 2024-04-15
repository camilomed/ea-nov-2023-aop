package com.example.springdata.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Product {

    @Id
    private  long id;
    private String name;
    private double price;
    private double rating;
    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "product")
    private List<Review> reviews;


}
