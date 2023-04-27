package com.isaenkobook.bookstore.controller;

import com.isaenkobook.bookstore.model.dto.BookReqDTO;
import com.isaenkobook.bookstore.model.dto.BookRespDTO;
import com.isaenkobook.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<? super List<BookRespDTO>> findBooks() {
        List<BookRespDTO> books = bookService.findBooks();
        return books.isEmpty() ? new ResponseEntity<>("Books not found", HttpStatus.NOT_FOUND) :
                ResponseEntity.status(200).body(books);
    }

//    @GetMapping("/books/{title}")
//    public ResponseEntity<? super BookRespDTO> findBooksByTitle(@PathVariable("title") String title) {
//        List<BookRespDTO> booksByTitle = bookService.findBooksByTitle(title);
//        return booksByTitle.isEmpty() ? new ResponseEntity<>("Books not found", HttpStatus.NOT_FOUND) :
//                ResponseEntity.status(200).body(booksByTitle);
//    }

    @GetMapping("/books/{title}")
    public String getBooksByTitle(@RequestParam("title") String title, Model model) {
        List<BookRespDTO> booksByTitle = bookService.findBooksByTitle(title);
        if (booksByTitle.isEmpty()) {
            model.addAttribute("errorMessage", "Books not found");
        } else {
            model.addAttribute("books", booksByTitle);
        }
        return "books-1";
    }













    @GetMapping("/books/{id}")
    public ResponseEntity<? super BookRespDTO> findBooksById(@PathVariable("id") Long bookId) {
        Optional<BookRespDTO> bookById = bookService.findBookById(bookId);
        return bookById.isEmpty() ? new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND) :
                ResponseEntity.status(200).body(bookById);
    }

    @PostMapping("books")
    public ResponseEntity<? super BookRespDTO> createBook(@RequestBody(required = false) BookReqDTO bookReqDTO) {
        if (bookReqDTO == null) {
            return new ResponseEntity<>("Request cannot be empty", HttpStatus.BAD_REQUEST);
        }
        BookRespDTO book = bookService.createBook(bookReqDTO);
        return ResponseEntity.status(201).body(book);
    }

    @PutMapping("books/{id}")
    public ResponseEntity<? super BookRespDTO> updateBook(@RequestBody Map<Object, Object> fields,
                                                          @PathVariable("id") Long bookId) {
        BookRespDTO updateBook = bookService.updateBook(fields, bookId);
        return ResponseEntity.status(200).body(updateBook);

    }

    @DeleteMapping("books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long bookId) {
        return bookService.deleteBook(bookId) ? new ResponseEntity<String>("Book with id: " +
                bookId + " deleted", HttpStatus.OK) : new ResponseEntity<String>("Book with id: " +
                bookId + " does not exist", HttpStatus.NO_CONTENT);
    }
}
