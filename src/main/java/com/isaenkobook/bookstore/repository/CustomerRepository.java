package com.isaenkobook.bookstore.repository;

import com.isaenkobook.bookstore.model.Book;
import com.isaenkobook.bookstore.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {
    @Override
    List<Customer> findAll();
}
