package com.isaenkobook.bookstore.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CartItem {
    private  Book book;
    private  Integer quantity;

}
