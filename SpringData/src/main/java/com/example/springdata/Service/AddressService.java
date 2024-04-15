package com.example.springdata.Service;

import com.example.springdata.Entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddress();
    Address getAdressById(long id);
    Address saveAddress(Address address);
    void  deleteAddress (long id);
}
