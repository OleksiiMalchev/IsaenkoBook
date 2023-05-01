package com.isaenkobook.bookstore.mapper;

import com.isaenkobook.bookstore.model.Book;
import com.isaenkobook.bookstore.model.dto.BookReqDTO;
import com.isaenkobook.bookstore.model.dto.BookRespDTO;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public Book toBook(BookReqDTO bookReqDTO) {
        return Book.builder()
                .title(bookReqDTO.getTitle())
                .authorId(bookReqDTO.getAuthorId())
                .cover(bookReqDTO.getCover())

                .language(bookReqDTO.getLanguage())
                .price(bookReqDTO.getPrice())
                .build();
    }


    public BookRespDTO toBookRespDTO(Book book) {
        return BookRespDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .authorId(book.getAuthorId())
                .language(book.getLanguage())

                .price(book.getPrice())
                .build();
    }


}
