package com.isaenkobook.bookstore.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CustomerAddressReqDTO {
    private Long customerId;
    private String country;
    private String city;
    private String postalCode;
    private String street;
    private String houseNumber;
}
