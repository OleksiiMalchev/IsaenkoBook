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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final CustomerRepository customerRepository;

    @Override
    public List<OrderRespDTO> findOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toOrderRespDTO).toList();
    }

    @Override
    public List<OrderRespDTO> findOrdersByCustomerId(Long customerId) {
        return orderRepository.findOrdersByCustomerId(customerId)
                .stream()
                .map(orderMapper::toOrderRespDTO).toList();
    }

    @Override
    public List<OrderRespDTO> findOrdersByStatus(String statusName) {
        return orderRepository.findOrdersByStatus(statusName).stream()
                .map(orderMapper::toOrderRespDTO).toList();
    }

    @Override
    public Optional<OrderRespDTO> findOrderById(Long orderId) {
        return orderRepository.findById(orderId).map(orderMapper::toOrderRespDTO);
    }


    @Override
    public OrderRespDTO createOrder(Long customerId) {
        if (customerId != null && customerRepository.existsById(customerId)) {
            Order order = Order.builder().customerId(customerId).createdAt(LocalDateTime.now())
                    .changeAt(LocalDateTime.now()).orderStatus(OrderStatus.NEW).build();
            Order saveOrder = orderRepository.save(order);
            return orderMapper.toOrderRespDTO(saveOrder);
        }
        return null;
    }

    @Override
    public OrderRespDTO updateOrder(Order order, List<OrderDetails> orderDetailsList, OrderStatus orderStatus) {
        return null;
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
