package com.isaenkobook.bookstore.service.impl;

import com.isaenkobook.bookstore.model.BookMeta;
import com.isaenkobook.bookstore.repository.BookMetaRepository;
import com.isaenkobook.bookstore.service.BookMetaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookMetaServiceImpl implements BookMetaService {
    private final BookMetaRepository bookMetaRepository;



    @Override
    public BookMeta findByArticleAndLocale(String article, String locale) {
       return bookMetaRepository.findByArticleAndLocale(article,locale);
    }
}
