package com.isaenkobook.bookstore.service;

import com.isaenkobook.bookstore.model.dto.CustomerReqDTO;
import com.isaenkobook.bookstore.model.dto.CustomerRespDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public interface CustomerService {
    List<CustomerRespDTO> findCustomers();

    Optional<CustomerRespDTO> findCustomerById(Long customerId);

    CustomerRespDTO createCustomer(CustomerReqDTO customerReqDTO);

    CustomerRespDTO updateCustomer(Map<Object, Object> fields, Long customerId);

    boolean deleteCustomer(Long customerId);
}
