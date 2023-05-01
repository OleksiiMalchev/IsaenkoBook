package com.isaenkobook.bookstore.service.impl;

import com.isaenkobook.bookstore.model.OrderDetails;
import com.isaenkobook.bookstore.model.dto.CartItemRespDTO;
import com.isaenkobook.bookstore.repository.OrderDetailsRepository;
import com.isaenkobook.bookstore.service.OrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailsServiceImpl implements OrderDetailsService {
    private final OrderDetailsRepository orderDetailsRepository;

    @Override
    public void createOrderDetails(Long orderId, List<CartItemRespDTO> cartItemRespDTO) {
        for (CartItemRespDTO cartItem : cartItemRespDTO) {
            OrderDetails orderDetails = OrderDetails.builder().orderId(orderId).bookId(cartItem.getBookId()).build();
            orderDetailsRepository.save(orderDetails);
        }
    }
}
