package com.isaenkobook.bookstore.mapper;

import com.isaenkobook.bookstore.model.CustomerAddress;
import com.isaenkobook.bookstore.model.dto.CustomerAddressReqDTO;
import com.isaenkobook.bookstore.model.dto.CustomerAddressRespDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerAddressMapper {

    public CustomerAddress toCustomerAddress(CustomerAddressReqDTO customerAddressReqDTO) {
        return CustomerAddress.builder()
                .customerId(customerAddressReqDTO.getCustomerId())
                .country(customerAddressReqDTO.getCountry())
                .city(customerAddressReqDTO.getCity())
                .address(customerAddressReqDTO.getAddress())
                .postOffice(customerAddressReqDTO.getPostOffice()).build();
    }


    public CustomerAddressRespDTO toCustomerAddressRespDTO(CustomerAddress customerAddress) {
        return CustomerAddressRespDTO.builder()
                .country(customerAddress.getCountry())
                .city(customerAddress.getCity())
                .address(customerAddress.getAddress())
                .postOffice(customerAddress.getPostOffice()).build();
    }
}

