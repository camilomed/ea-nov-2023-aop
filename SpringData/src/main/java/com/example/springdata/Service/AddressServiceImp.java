package com.example.springdata.Service;

import com.example.springdata.Entity.Address;
import com.example.springdata.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressServiceImp implements  AddressService{

    @Autowired
    private AddressRepository addressRepository;
    @Override
    public List<Address> getAllAddress() {
        return this.addressRepository.findAll();
    }

    @Override
    public Address getAdressById(long id) {
        return this.addressRepository.findById(id).get();
    }

    @Override
    public Address saveAddress(Address address) {
        return this.addressRepository.save(address);
    }

    @Override
    public void deleteAddress(long id) {
        this.addressRepository.deleteById(id);
    }

}
