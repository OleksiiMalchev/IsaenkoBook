package com.isaenkobook.bookstore.mapper;

import com.isaenkobook.bookstore.model.Author;
import com.isaenkobook.bookstore.model.dto.AuthorReqDTO;
import com.isaenkobook.bookstore.model.dto.AuthorRespDTO;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {
    public Author toAuthor(AuthorReqDTO reqDTO) {
        return Author.builder()
                .bio(reqDTO.getBio())
                .firstName(reqDTO.getFirstName())
                .lastName(reqDTO.getLastName())
                .build();
    }
    public AuthorRespDTO toAuthorRespDTO(Author author) {
        return AuthorRespDTO.builder()
                .bio(author.getBio())
                .firstName(author.getFirstName())
                .lastName(author.getLastName())
                .authorId(author.getId())
                .build();
    }
}
