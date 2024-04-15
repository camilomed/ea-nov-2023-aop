package com.example.springdata.controller;

import com.example.springdata.Entity.Address;
import com.example.springdata.Service.AddressServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressServiceImp addressServiceImp;
    @PostMapping
    public ResponseEntity<Address> addAddress(@RequestBody Address address){
        this.addressServiceImp.saveAddress(address);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddress(){
        List<Address> addresses = this.addressServiceImp.getAllAddress();
        return new ResponseEntity<>(addresses,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable long id){
        Address address = this.addressServiceImp.getAdressById(id);
        return  new ResponseEntity<>(address,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Address> deleteAddress(@PathVariable long id){
        if(this.addressServiceImp.getAdressById(id)==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Address addressDeleted = this.addressServiceImp.getAdressById(id);
        this.addressServiceImp.deleteAddress(id);
        return new ResponseEntity<>(addressDeleted,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable long id,@RequestBody Address address){
        if(this.addressServiceImp.getAdressById(id)==null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(id!=address.getId()){
            return  new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        this.addressServiceImp.saveAddress(address);
        return  new ResponseEntity<>(address,HttpStatus.OK);
    }
}
