package com.example.springdata.Repository;

import com.example.springdata.Entity.Address;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends ListCrudRepository<Address,Long> {


}
