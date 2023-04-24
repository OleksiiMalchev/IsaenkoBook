package com.isaenkobook.bookstore.service;

import com.isaenkobook.bookstore.model.dto.AuthorReqDTO;
import com.isaenkobook.bookstore.model.dto.AuthorRespDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public interface AuthorService {
    List<AuthorRespDTO> findAuthors();

    Optional<AuthorRespDTO> findAuthorById(Long authorId);

    AuthorRespDTO createAuthor(AuthorReqDTO authorReqDTO);

    AuthorRespDTO updateAuthor(Map<Object, Object> fields, Long authorId);

    boolean deleteAuthor(Long authorId);



}
