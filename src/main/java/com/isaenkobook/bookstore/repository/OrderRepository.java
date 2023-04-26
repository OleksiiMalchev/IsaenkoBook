package com.isaenkobook.bookstore.repository;

import com.isaenkobook.bookstore.model.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {
    @Override
    List<Order> findAll();

    @Query("SELECT o FROM Order o JOIN FETCH o.customer c WHERE c.id = :id")
    List<Order> findOrdersByCustomerId(@Param("id") Long idCustomer);

    @Query(value = "SELECT * FROM orders JOIN order_status ON orders.id = order_status.order_id " +
            "Where order_status.name_status = :statusName ", nativeQuery = true)
    List<Order> findOrdersByStatus(@Param("statusName") String statusName);


}
