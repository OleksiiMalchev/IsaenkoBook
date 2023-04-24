package com.isaenkobook.bookstore.mapper;

import com.isaenkobook.bookstore.model.Book;
import com.isaenkobook.bookstore.model.dto.BookReqDTO;
import com.isaenkobook.bookstore.model.dto.BookRespDTO;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public Book toBook(BookReqDTO bookReqDto) {
        return Book.builder()
                .title(bookReqDto.getTitle())
                .authorId(bookReqDto.getAuthorId())
                .cover(bookReqDto.getCover())
                .formatBook(bookReqDto.getFormatBook())
                .language(bookReqDto.getLanguage())
                .price(bookReqDto.getPrice())
                .build();
    }


    public BookRespDTO toBookRespDTO(Book book) {
        return BookRespDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .authorId(book.getAuthorId())
                .language(book.getLanguage())
                .formatBook(book.getFormatBook())
                .price(book.getPrice())
                .build();
    }


}
