package com.isaenkobook.bookstore.controller;

import com.isaenkobook.bookstore.model.dto.AuthorReqDTO;
import com.isaenkobook.bookstore.model.dto.AuthorRespDTO;
import com.isaenkobook.bookstore.model.dto.CustomerReqDTO;
import com.isaenkobook.bookstore.model.dto.CustomerRespDTO;
import com.isaenkobook.bookstore.service.AuthorService;
import com.isaenkobook.bookstore.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;


    @GetMapping("/customers")
    public ResponseEntity<? super CustomerRespDTO> findCustomers() {
        List<CustomerRespDTO> customers = customerService.findCustomers();
        return customers.isEmpty() ? new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND) :
                ResponseEntity.status(200).body(customers);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<? super CustomerRespDTO> findCustomerById(@PathVariable("id") Long customerId) {
        Optional<CustomerRespDTO> customerById = customerService.findCustomerById(customerId);
        return customerById .isPresent() ? ResponseEntity.status(200).body(customerById ) :
                new ResponseEntity<>("Customer with id:" + customerId + " not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/customers")
    public ResponseEntity<? super CustomerRespDTO> createCustomer(@RequestBody CustomerReqDTO customerReqDTO) {
        if (customerReqDTO == null) {
            return new ResponseEntity<>("Request cannot be empty", HttpStatus.BAD_REQUEST);

        }
        CustomerRespDTO customer = customerService.createCustomer(customerReqDTO);
        return ResponseEntity.status(201).body(customer);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<? super AuthorRespDTO> updateCustomer(@RequestBody Map<Object, Object> fields,
                                                              @PathVariable("id") Long customerId) {
        CustomerRespDTO customerRespDTO = customerService.updateCustomer(fields, customerId);
        return ResponseEntity.status(200).body(customerRespDTO);

    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long customerId) {
        return customerService.deleteCustomer(customerId)? new ResponseEntity<String>("Customer with id: " +
                customerId + " deleted", HttpStatus.OK) : new ResponseEntity<String>("Customer with id: " +
                customerId + " does not exist", HttpStatus.NO_CONTENT);
    }
}
