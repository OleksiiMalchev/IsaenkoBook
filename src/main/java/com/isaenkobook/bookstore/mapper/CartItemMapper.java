package com.isaenkobook.bookstore.mapper;

import com.isaenkobook.bookstore.model.CartItem;

import com.isaenkobook.bookstore.model.dto.CartItemRespDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartItemMapper {

    private final BookMapper bookMapper;
    public CartItemRespDTO toCartItemRespDTO(CartItem cartItem) {
        return CartItemRespDTO.builder()
                .bookId(cartItem.getBook().getId())
                .quantity(cartItem.getQuantity())
                .bookRespDTO(bookMapper.toBookRespDTO(cartItem.getBook()))
                .build();
    }
}
