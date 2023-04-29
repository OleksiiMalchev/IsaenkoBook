package com.isaenkobook.bookstore.model.dto;

import com.isaenkobook.bookstore.model.Author;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class BookRespDTO {

    private Long id;
    private Long authorId;
    private String title;
    private String cover;
    private String language;
    private String formatBook;
    private BigDecimal price;
    private String article;

}
