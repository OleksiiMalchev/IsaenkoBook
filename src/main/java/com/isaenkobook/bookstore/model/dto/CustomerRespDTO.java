package com.isaenkobook.bookstore.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CustomerRespDTO {
    private Long customerId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String mobile;
    private String email;
}
