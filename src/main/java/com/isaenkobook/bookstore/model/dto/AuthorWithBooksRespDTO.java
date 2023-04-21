package com.isaenkobook.bookstore.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class AuthorWithBooksRespDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String bio;
    private List<BookRespDTO> listBooks;
}
