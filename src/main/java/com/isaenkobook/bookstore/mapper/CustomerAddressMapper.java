package com.isaenkobook.bookstore.mapper;

import com.isaenkobook.bookstore.model.CustomerAddress;
import com.isaenkobook.bookstore.model.dto.CustomerAddressReqDTO;
import com.isaenkobook.bookstore.model.dto.CustomerAddressRespDTO;
import com.isaenkobook.bookstore.model.dto.PayReqDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerAddressMapper {

    public CustomerAddress toCustomerAddress(PayReqDTO payReqDTO, Long customerId) {
        return CustomerAddress.builder()
                .customerId(customerId)
                .country(payReqDTO.getCountry())
                .city(payReqDTO.getCity())
                .address(payReqDTO.getAddress())
                .postOffice(payReqDTO.getPostOffice()).build();
    }


    public CustomerAddressRespDTO toCustomerAddressRespDTO(CustomerAddress customerAddress) {
        return CustomerAddressRespDTO.builder()
                .country(customerAddress.getCountry())
                .city(customerAddress.getCity())
                .address(customerAddress.getAddress())
                .postOffice(customerAddress.getPostOffice()).build();
    }
}

