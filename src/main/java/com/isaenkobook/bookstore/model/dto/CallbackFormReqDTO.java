package com.isaenkobook.bookstore.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CallbackFormReqDTO {

    private Long id;
    private String name;
    private String email;
    private String message;
}
