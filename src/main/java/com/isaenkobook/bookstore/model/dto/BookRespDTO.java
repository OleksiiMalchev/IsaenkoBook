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
public class BookRespDTO {
    private Long id;
    private String title;
    private Long authorId;
    private Language language;
    private Format formatBook;
    private BigDecimal price;
    private String cover;
}
