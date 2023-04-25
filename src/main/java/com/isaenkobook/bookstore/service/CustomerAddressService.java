package com.isaenkobook.bookstore.service;

import com.isaenkobook.bookstore.model.dto.CustomerAddressReqDTO;
import com.isaenkobook.bookstore.model.dto.CustomerAddressRespDTO;
import com.isaenkobook.bookstore.model.dto.CustomerReqDTO;
import com.isaenkobook.bookstore.model.dto.CustomerRespDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public interface CustomerAddressService {
    List<CustomerAddressRespDTO> findAddress();

    Optional<CustomerAddressRespDTO> findAddressById(Long customerAddressId);


    CustomerAddressRespDTO createCustomerAddress(CustomerAddressReqDTO customerAddressReqDTO);

    CustomerAddressRespDTO updateCustomerAddress(Map<Object, Object> fields, Long customerAddressId);

    boolean deleteCustomerAddress(Long customerAddressId);
}
