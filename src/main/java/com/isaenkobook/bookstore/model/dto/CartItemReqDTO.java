package com.isaenkobook.bookstore.model.dto;

import com.isaenkobook.bookstore.model.Book;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CartItemReqDTO {
    private final Long bookId;
    private final Integer quantity;
}
