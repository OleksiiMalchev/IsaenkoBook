package com.isaenkobook.bookstore.service.impl;

import com.isaenkobook.bookstore.mapper.CustomerAddressMapper;
import com.isaenkobook.bookstore.model.Book;
import com.isaenkobook.bookstore.model.CustomerAddress;
import com.isaenkobook.bookstore.model.dto.CustomerAddressReqDTO;
import com.isaenkobook.bookstore.model.dto.CustomerAddressRespDTO;
import com.isaenkobook.bookstore.repository.CustomerAddressRepository;
import com.isaenkobook.bookstore.repository.CustomerRepository;
import com.isaenkobook.bookstore.service.CustomerAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerAddressServiceImpl implements CustomerAddressService {
    private final CustomerAddressRepository customerAddressRepository;
    private final CustomerAddressMapper customerAddressMapper;
    private final CustomerRepository customerRepository;


    @Override
    public List<CustomerAddressRespDTO> findAddress() {
        return customerAddressRepository.findAll().stream()
                .map(customerAddressMapper::toCustomerAddressRespDTO).toList();
    }

    @Override
    public Optional<CustomerAddressRespDTO> findAddressById(Long customerAddressId) {
        return customerAddressRepository.findById(customerAddressId)
                .map(customerAddressMapper::toCustomerAddressRespDTO);
    }


    @Override
    public CustomerAddressRespDTO createCustomerAddress(CustomerAddressReqDTO customerAddressReqDTO) {
        if (!customerAddressRepository.existsById(customerAddressReqDTO.getCustomerId())) {
            return null;
        }
        CustomerAddress customerAddress = customerAddressMapper.toCustomerAddress(customerAddressReqDTO);
        CustomerAddress saveCustomerAddressInBase = customerAddressRepository.save(customerAddress);
        return customerAddressMapper.toCustomerAddressRespDTO(saveCustomerAddressInBase);
    }


    @Override
    public CustomerAddressRespDTO updateCustomerAddress(Map<Object, Object> fields, Long customerAddressId) {
        if (customerAddressRepository.existsById(customerAddressId)) {
            CustomerAddress customerAddress = customerAddressRepository.findById(customerAddressId).get();
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Book.class, (String) key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, customerAddress, value);
            });
            CustomerAddress updateAddressInBase = customerAddressRepository.save(customerAddress);
            return customerAddressMapper.toCustomerAddressRespDTO(updateAddressInBase);
        }
        return null;
    }

    @Override
    public boolean deleteCustomerAddress(Long customerAddressId) {
        if (customerAddressRepository.existsById(customerAddressId)) {
            customerAddressRepository.deleteById(customerAddressId);
            return true;
        }
        return false;
    }
}
