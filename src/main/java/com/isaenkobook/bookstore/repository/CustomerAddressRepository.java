package com.isaenkobook.bookstore.repository;

import com.isaenkobook.bookstore.model.CustomerAddress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerAddressRepository extends CrudRepository<CustomerAddress,Long> {
    @Override
    List<CustomerAddress> findAll();

}
