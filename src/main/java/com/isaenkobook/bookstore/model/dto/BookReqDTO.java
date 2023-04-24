package com.isaenkobook.bookstore.model.dto;

import com.isaenkobook.bookstore.model.Format;
import com.isaenkobook.bookstore.model.Language;
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
    private Language language;
    private Format formatBook;
    private String cover;
    private BigDecimal price;
}
