package com.isaenkobook.bookstore.mapper;

import com.isaenkobook.bookstore.model.Customer;
import com.isaenkobook.bookstore.model.dto.CustomerReqDTO;
import com.isaenkobook.bookstore.model.dto.CustomerRespDTO;
import com.isaenkobook.bookstore.model.dto.PayReqDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toCustomer(PayReqDTO payReqDTO) {
        return Customer.builder()
                .firstName(payReqDTO.getFirstName())
                .lastName(payReqDTO.getLastName())
                .mobile(payReqDTO.getMobile())
                .email(payReqDTO.getEmail()).build();
    }

    public CustomerRespDTO toCustomerRespDTO(Customer customer) {
        if(customer!=null){
            return CustomerRespDTO.builder().customerId(customer.getId())
                    .firstName(customer.getFirstName())
                    .lastName(customer.getLastName())
                    .middleName(customer.getMiddleName())
                    .email(customer.getEmail())
                    .mobile(customer.getMobile())
                    .build();
        }
        return null;
    }
}
