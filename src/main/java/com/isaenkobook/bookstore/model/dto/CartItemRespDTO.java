package com.isaenkobook.bookstore.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CartItemRespDTO {
    private final Long bookId;
    private final Integer quantity;
    private final BookRespDTO bookRespDTO;
}
