package com.isaenkobook.bookstore.mapper;

import com.isaenkobook.bookstore.model.Order;
import com.isaenkobook.bookstore.model.dto.OrderReqDTO;
import com.isaenkobook.bookstore.model.dto.OrderRespDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final OrderDetailsMapper orderDetailsMapper;

    public Order toOrder(OrderReqDTO orderReqDTO) {
        return Order.builder()
                .customerId(orderReqDTO.getCustomerId()).build();
    }

    public OrderRespDTO toOrderRespDTO(Order order) {
        if (order != null) {
            return OrderRespDTO.builder()
                    .id(order.getId())
                    .createdAt(order.getCreatedAt())
                    .changeAt(order.getChangeAt())
                    .orderStatus(order.getOrderStatus())
                    .orderDetails(order.getOrderDetails()
                            .stream()
                            .map(orderDetailsMapper::toOrderDetailsRespDTO).toList()
                    ).build();
        }
        return null;
    }
}
