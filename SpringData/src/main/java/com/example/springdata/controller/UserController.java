package com.example.springdata.controller;

import com.example.springdata.Entity.User;
import com.example.springdata.Service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserServiceImp UserServiceImp;
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User User){
        this.UserServiceImp.saveUser(User);
        return new ResponseEntity<>(User, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users = this.UserServiceImp.getAllUser();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id){
        User User = this.UserServiceImp.getUserById(id);
        return  new ResponseEntity<>(User,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable long id){
        if(this.UserServiceImp.getUserById(id)==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        User UserDeleted = this.UserServiceImp.getUserById(id);
        this.UserServiceImp.deleteUser(id);
        return new ResponseEntity<>(UserDeleted,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id,@RequestBody User User){
        if(this.UserServiceImp.getUserById(id)==null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(id!=User.getId()){
            return  new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        this.UserServiceImp.saveUser(User);
        return  new ResponseEntity<>(User,HttpStatus.OK);
    }
}
