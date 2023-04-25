package com.isaenkobook.bookstore.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CustomerAddressRespDTO {

    private String country;
    private String city;
    private String address;
    private String postOffice;
}
