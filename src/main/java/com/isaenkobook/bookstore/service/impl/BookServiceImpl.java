package com.isaenkobook.bookstore.service.impl;

import com.isaenkobook.bookstore.mapper.BookMapper;
import com.isaenkobook.bookstore.model.Book;
import com.isaenkobook.bookstore.model.dto.BookReqDTO;
import com.isaenkobook.bookstore.model.dto.BookRespDTO;
import com.isaenkobook.bookstore.repository.AuthorRepository;
import com.isaenkobook.bookstore.repository.BookRepository;
import com.isaenkobook.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;


    @Override
    public List<BookRespDTO> findBooks() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toBookRespDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookRespDTO> findBooksByTitle(String title) {
        return bookRepository.findByTitle(title).stream().map(bookMapper::toBookRespDTO)
                .collect(Collectors.toList());
    }


    @Override
    public Optional<BookRespDTO> findBookById(Long bookId) {
        return bookRepository.findById(bookId)
                .map(bookMapper::toBookRespDTO);
    }

    @Override
    public BookRespDTO createBook(BookReqDTO bookReqDto) {
        if (!authorRepository.existsById(bookReqDto.getAuthorId())) {
            return null;
        }
        Book book = bookMapper.toBook(bookReqDto);
        Book saveBookInBase = bookRepository.save(book);
        return bookMapper.toBookRespDTO(saveBookInBase);
    }

    @Override
    public BookRespDTO updateBook(Map<Object, Object> fields, Long bookId) {
        if (bookRepository.existsById(bookId)) {
            Book bookInBase = bookRepository.findById(bookId).get();
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Book.class, (String) key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, bookInBase, value);
            });
            Book saveBookInBase = bookRepository.save(bookInBase);
            return bookMapper.toBookRespDTO(saveBookInBase);
        }
        return null;
    }

    @Override
    public boolean deleteBook(Long bookId) {
        if (bookRepository.existsById(bookId)) {
            bookRepository.deleteById(bookId);
            return true;
        }
        return false;
    }
}
