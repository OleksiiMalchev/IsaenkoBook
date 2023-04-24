package com.isaenkobook.bookstore.model.dto;

import com.isaenkobook.bookstore.model.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class OrderRespDTO {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime changeAt;
    private OrderStatus orderStatus;
    private List<OrderDetailsRespDTO> orderDetails;
}
