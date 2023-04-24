package com.isaenkobook.bookstore.mapper;

import com.isaenkobook.bookstore.model.CartItem;
import com.isaenkobook.bookstore.model.dto.BookRespDTO;
import com.isaenkobook.bookstore.model.dto.CartItemRespDTO;
import org.springframework.stereotype.Component;

@Component
public class CartItemMapper {
    public CartItemRespDTO toCartItemRespDTO(CartItem cartItem) {
        return CartItemRespDTO.builder()
                .bookId(cartItem.getBook().getId())
                .quantity(cartItem.getQuantity())
                .build();
    }
}
