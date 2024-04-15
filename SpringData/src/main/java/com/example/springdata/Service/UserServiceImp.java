package com.example.springdata.Service;

import com.example.springdata.Entity.User;
import com.example.springdata.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return this.userRepository.findById(id).get();
    }

    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public void deleteUser(long id) {
        this.userRepository.deleteById(id);
    }
}
