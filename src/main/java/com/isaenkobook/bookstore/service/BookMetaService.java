package com.isaenkobook.bookstore.service;

import com.isaenkobook.bookstore.model.BookMeta;
import org.springframework.stereotype.Service;

@Service
public interface BookMetaService {

    BookMeta findByArticleAndLocale(String article, String locale);
}
