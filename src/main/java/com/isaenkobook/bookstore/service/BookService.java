package com.isaenkobook.bookstore.service;

import com.isaenkobook.bookstore.model.dto.BookReqDTO;
import com.isaenkobook.bookstore.model.dto.BookRespDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public interface BookService {
    List<BookRespDTO> findBooks();
    List<BookRespDTO> findBooksByTitle(String title);
    List<BookRespDTO> findBooksByLangAndArticle(String lang,String article);
    Optional<BookRespDTO> findBookById(Long bookId);
    BookRespDTO createBook(BookReqDTO bookReqDto);

    BookRespDTO updateBook(Map<Object, Object> fields, Long bookId);

    boolean deleteBook(Long bookId);
}
