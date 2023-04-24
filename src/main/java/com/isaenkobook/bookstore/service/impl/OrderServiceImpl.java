package com.isaenkobook.bookstore.service.impl;

import com.isaenkobook.bookstore.mapper.OrderMapper;
import com.isaenkobook.bookstore.model.Order;
import com.isaenkobook.bookstore.model.OrderDetails;
import com.isaenkobook.bookstore.model.OrderStatus;
import com.isaenkobook.bookstore.model.dto.OrderRespDTO;
import com.isaenkobook.bookstore.repository.CustomerRepository;
import com.isaenkobook.bookstore.repository.OrderRepository;
import com.isaenkobook.bookstore.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final CustomerRepository customerRepository;

    @Override
    public List<OrderRespDTO> findOrders() {
        return orderRepository.findAll().stream().map(orderMapper::toOrderRespDTO).toList();
    }

    @Override
    public Optional<OrderRespDTO> findOrderById(Long orderId) {
        return orderRepository.findById(orderId).map(orderMapper::toOrderRespDTO);
    }

    @Override
    public OrderRespDTO createOrder(Long customerId) {
        if(customerRepository.existsById(customerId)){
            Order order = Order.builder().customerId(customerId)
                    .createdAt(LocalDateTime.now())
                    .changeAt(LocalDateTime.now())
                    .orderStatus(OrderStatus.NEW).build();
            orderRepository.save(order);
            return orderMapper.toOrderRespDTO(order);
        }
        return null;
    }

    @Override
    public OrderRespDTO updateOrder(Order order, List<OrderDetails> orderDetails, OrderStatus orderStatus) {
        order.setOrderDetails(orderDetails);
        order.setChangeAt(LocalDateTime.now());
        order.setOrderStatus(orderStatus);
        Order saveOrder = orderRepository.save(order);
        return orderMapper.toOrderRespDTO(saveOrder);
    }

    @Override
    public boolean deleteOrder(Long orderId) {
        if (orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);
            return true;
        }
        return false;
    }
}
