package com.isaenkobook.bookstore.service;

import com.isaenkobook.bookstore.model.Order;
import com.isaenkobook.bookstore.model.OrderDetails;
import com.isaenkobook.bookstore.model.OrderStatus;
import com.isaenkobook.bookstore.model.dto.OrderRespDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {
    List<OrderRespDTO> findOrders();

    List<OrderRespDTO> findOrdersByCustomerId(Long customerId);

    List<OrderRespDTO> findOrderByStatus(String statusName);

    Optional<OrderRespDTO> findOrdersById(Long orderId);

    Optional<OrderRespDTO> findOrdersByCustomerIdAndStatus(Long customerId, String statusName);

    OrderRespDTO createOrder(Long customerId);

    OrderRespDTO updateOrder(Order order, List<OrderDetails> orderDetailsList, OrderStatus orderStatus);

    boolean deleteOrder(Long orderId);

}
