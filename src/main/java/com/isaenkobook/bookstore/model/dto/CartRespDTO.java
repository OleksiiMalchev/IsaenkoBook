package com.isaenkobook.bookstore.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Builder
public class CartRespDTO {
    private List<CartItemRespDTO> cartItems ;
    private String totalPrice;
}
