package com.isaenkobook.bookstore.service.impl;

import com.isaenkobook.bookstore.mapper.CustomerMapper;
import com.isaenkobook.bookstore.model.Author;
import com.isaenkobook.bookstore.model.Customer;
import com.isaenkobook.bookstore.model.dto.CustomerReqDTO;
import com.isaenkobook.bookstore.model.dto.CustomerRespDTO;
import com.isaenkobook.bookstore.repository.CustomerRepository;
import com.isaenkobook.bookstore.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    @Override
    public List<CustomerRespDTO> findCustomers() {
        return customerRepository.findAll().stream().map(customerMapper::toCustomerRespDTO).toList();
    }

    @Override
    public Optional<CustomerRespDTO> findCustomerById(Long customerId) {
        return customerRepository.findById(customerId).map(customerMapper::toCustomerRespDTO);
    }

    @Override
    public CustomerRespDTO createCustomer(CustomerReqDTO customerReqDTO) {
        Customer customer = customerMapper.toCustomer(customerReqDTO);
        Customer customerSaveInBase = customerRepository.save(customer);
        return customerMapper.toCustomerRespDTO(customerSaveInBase);
    }

    @Override
    public CustomerRespDTO updateCustomer(Map<Object, Object> fields, Long customerId) {
        if (customerRepository.existsById(customerId)) {
            Customer customerInBase = customerRepository.findById(customerId).get();
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Customer.class, (String) key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, customerInBase, value);
            });
            Customer customerUpdate = customerRepository.save(customerInBase);
            return customerMapper.toCustomerRespDTO(customerUpdate);
        }
        return null;
    }

    @Override
    public boolean deleteCustomer(Long customerId) {
        if (customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId);
            return true;
        }
        return false;
    }
}
