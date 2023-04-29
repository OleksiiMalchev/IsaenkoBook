package com.isaenkobook.bookstore.controller;


import com.isaenkobook.bookstore.model.BookMeta;
import com.isaenkobook.bookstore.service.BookMetaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookMetaController {
    private final BookMetaService bookMetaService;

//    @GetMapping("/bookm/{article}")
//    public BookMeta getMeta(@PathVariable("article") String article) {
//        return bookMetaService.findByArticle(article);
//    }

//    @GetMapping("bookm_m/{article1}")
//    public BookMeta getBookMeta(@PathVariable String article, @RequestParam String locale) {
//        return bookMetaService.findByArticleAndLocale(article, locale);
//    }
}
