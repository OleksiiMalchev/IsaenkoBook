package com.isaenkobook.bookstore.repository;

import com.isaenkobook.bookstore.model.OrderDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends CrudRepository<OrderDetails,Long> {
}
