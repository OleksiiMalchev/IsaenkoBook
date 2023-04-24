package com.isaenkobook.bookstore.controller;

import com.isaenkobook.bookstore.model.dto.AuthorReqDTO;
import com.isaenkobook.bookstore.model.dto.AuthorRespDTO;
import com.isaenkobook.bookstore.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;


    @GetMapping("/authors")
    public ResponseEntity<? super AuthorRespDTO> findAuthors() {
        List<AuthorRespDTO> authors = authorService.findAuthors();
        return authors.isEmpty() ? new ResponseEntity<>("Authors not found", HttpStatus.NOT_FOUND) :
                ResponseEntity.status(200).body(authors);
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<? super AuthorRespDTO> findAuthorById(@PathVariable("id") Long authorId) {
        Optional<AuthorRespDTO> authorById = authorService.findAuthorById(authorId);
        return authorById.isPresent() ? ResponseEntity.status(200).body(authorById) :
                new ResponseEntity<>("Author with id:" + authorId + " not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/authors")
    public ResponseEntity<? super AuthorRespDTO> createAuthor(@RequestBody AuthorReqDTO authorReqDTO) {
        if (authorReqDTO == null) {
            return new ResponseEntity<>("Request cannot be empty", HttpStatus.BAD_REQUEST);

        }
        AuthorRespDTO author = authorService.createAuthor(authorReqDTO);
        return ResponseEntity.status(201).body(author);
    }

    @PutMapping("/authors/{id}")
    public ResponseEntity<? super AuthorRespDTO> updateAuthor(@RequestBody Map<Object, Object> fields,
                                                              @PathVariable("id") Long authorId) {
        AuthorRespDTO updateAuthor = authorService.updateAuthor(fields, authorId);
        return ResponseEntity.status(200).body(updateAuthor);

    }

    @DeleteMapping("/authors/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable("id") Long authorId) {
        return authorService.deleteAuthor(authorId) ? new ResponseEntity<String>("Author with id: " +
                authorId + " deleted", HttpStatus.OK) : new ResponseEntity<String>("Author with id: " +
                authorId + " does not exist", HttpStatus.NO_CONTENT);
    }
}
