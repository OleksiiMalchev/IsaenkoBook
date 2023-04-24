package com.isaenkobook.bookstore.repository;

import com.isaenkobook.bookstore.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {
    @Override
    List<Order> findAll();
}
