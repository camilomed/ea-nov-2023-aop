package com.example.springdata.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Address {
    @Id
    private  long id;
    private String street;
    private String zip;
    private String city;

    @OneToOne
    private User user;

}
