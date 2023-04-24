package com.isaenkobook.bookstore.mapper;

import com.isaenkobook.bookstore.model.Customer;
import com.isaenkobook.bookstore.model.dto.CustomerReqDTO;
import com.isaenkobook.bookstore.model.dto.CustomerRespDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public CustomerRespDTO toCustomerRespDTO(Customer customer) {
        return CustomerRespDTO.builder().customerId(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .middleName(customer.getMiddleName())
                .email(customer.getEmail())
                .mobile(customer.getMobile())
                .build();
    }

    public Customer toCustomer(CustomerReqDTO customerReqDTO) {
        return Customer.builder()
                .firstName(customerReqDTO.getFirstName())
                .middleName(customerReqDTO.getMiddleName())
                .lastName(customerReqDTO.getLastName())
                .mobile(customerReqDTO.getMobile())
                .email(customerReqDTO.getEmail()).build();
    }
}
