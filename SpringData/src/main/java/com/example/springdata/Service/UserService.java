package com.example.springdata.Service;

import com.example.springdata.Entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getUserById(long id);
    User saveUser(User User);
    void  deleteUser (long id);
}
