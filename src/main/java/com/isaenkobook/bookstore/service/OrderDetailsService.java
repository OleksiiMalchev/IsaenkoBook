package com.isaenkobook.bookstore.service;

import com.isaenkobook.bookstore.model.dto.CartItemRespDTO;
import com.isaenkobook.bookstore.model.dto.OrderDetailsRespDTO;
import com.isaenkobook.bookstore.model.dto.OrderRespDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDetailsService {
    void createOrderDetails(Long orderId, List<CartItemRespDTO> cartItemRespDTO);
}
