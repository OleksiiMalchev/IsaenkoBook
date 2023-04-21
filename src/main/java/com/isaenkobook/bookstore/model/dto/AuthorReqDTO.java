package com.isaenkobook.bookstore.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthorReqDTO {
    private String firstName;
    private String lastName;
    private String bio;
}
