package com.example.springdata.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Review {

    @Id
    private Long id;
    private String comment;
    @ManyToOne
    private User user;
    @ManyToOne
    private Product product;
}
