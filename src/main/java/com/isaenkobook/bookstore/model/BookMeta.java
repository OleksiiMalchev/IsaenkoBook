package com.isaenkobook.bookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "book_meta")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookMeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "background_image")
    private String backgroundImage; //style="background-image: url(image/book-bg-1.png);"> 90
    @Column(name = "book_hero_title")
    private String bookHeroTitle; //<h1 class="page-title book-hero__title">Невигадані істоії вигаданих людей</h1> 92
    @Column(name = "book_hero_text")
    private String bookHeroText; // <div class="book-hero__text"> 94
    @Column(name = "book_hero_img")
    private String bookHeroImg;//<picture><source srcset="img/main/books/book-1.webp" type="image/webp"><img src="img/main/books/book-1.png" alt=""></picture> 100
    @Column(name = "book_info_group_f")
    private String bookInfoGroupFS;//              <div class="book-info__group">106
    @Column(name = "book_info_title")
    private String bookInfoTitle; //<h2 class="section__title book-info__title">Книга, яка змусить замислитися</h2> 114
    @Column(name = "book_info_group_s")
    private String bookInfoGroupSS;//<div class="book-info__group">115
    @Column(name="p_s")
    private String postScript; //<span>P.S.</span> 124
    @Column(name="book_info_ps")
    private String bookInfoPs; //125 до 128
    @Column(name = "article")
    private String article;
    @Column(name="locale")
    private String locale;
}
