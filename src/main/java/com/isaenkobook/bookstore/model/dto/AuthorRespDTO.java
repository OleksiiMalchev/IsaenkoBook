package com.isaenkobook.bookstore.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Builder
public class AuthorRespDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String bio;
}
