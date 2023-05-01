package com.isaenkobook.bookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Table(name = "book")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "author_id")
    private Long authorId;
    @Column(name = "title")
    private String title;

    @Column(name = "cover")
    private String cover;

    @Column(name = "language")
    private String language;

    @Column(name = "format_book_uk")
    private String formatBookUK;

    @Column(name = "format_book_en")
    private String formatBookEN;


    @Column(name = "format_book_ru")
    private String formatBookRU;

    @Column(name = "book_img")
    private String bookImg;


    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "article")
    private String article;
    @ManyToOne
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    private Author author;
}
