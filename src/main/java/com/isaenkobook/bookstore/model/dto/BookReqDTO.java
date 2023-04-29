package com.isaenkobook.bookstore.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class BookReqDTO {
    private String title;
    private Long authorId;
    private String language;
    private String formatBook;
    private String cover;
    private BigDecimal price;
}
