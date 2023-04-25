package com.isaenkobook.bookstore.controller;

import com.isaenkobook.bookstore.model.dto.AuthorReqDTO;
import com.isaenkobook.bookstore.model.dto.AuthorRespDTO;
import com.isaenkobook.bookstore.model.dto.CustomerAddressReqDTO;
import com.isaenkobook.bookstore.model.dto.CustomerAddressRespDTO;
import com.isaenkobook.bookstore.service.AuthorService;
import com.isaenkobook.bookstore.service.CustomerAddressService;
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
public class CustomerAddressController {
    private final CustomerAddressService customerAddressService;


    @GetMapping("/address")
    public ResponseEntity<? super AuthorRespDTO> findAddress() {
        List<CustomerAddressRespDTO> address = customerAddressService.findAddress();
        return address.isEmpty() ? new ResponseEntity<>("Address not found", HttpStatus.NOT_FOUND) :
                ResponseEntity.status(200).body(address);
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<? super AuthorRespDTO> findAddressById(@PathVariable("id") Long addressId) {
        Optional<CustomerAddressRespDTO> addressById = customerAddressService.findAddressById(addressId);
        return addressById.isPresent() ? ResponseEntity.status(200).body(addressById) :
                new ResponseEntity<>("Address with id:" + addressById + " not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/address")
    public ResponseEntity<? super AuthorRespDTO> createAddress(@RequestBody CustomerAddressReqDTO customerAddressReqDTO) {
        if (customerAddressReqDTO == null) {
            return new ResponseEntity<>("Request cannot be empty", HttpStatus.BAD_REQUEST);

        }
        CustomerAddressRespDTO customerAddress = customerAddressService.createCustomerAddress(customerAddressReqDTO);
        return ResponseEntity.status(201).body(customerAddress);
    }

    @PutMapping("/address/{id}")
    public ResponseEntity<? super AuthorRespDTO> updateAddress(@RequestBody Map<Object, Object> fields,
                                                               @PathVariable("id") Long addressId) {
        CustomerAddressRespDTO customerAddressRespDTO = customerAddressService.updateCustomerAddress(fields, addressId);
        return ResponseEntity.status(200).body(customerAddressRespDTO);

    }

    @DeleteMapping("/address/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable("id") Long addressId) {
        return customerAddressService.deleteCustomerAddress(addressId) ? new ResponseEntity<String>("Address with id: " +
                addressId + " deleted", HttpStatus.OK) : new ResponseEntity<String>("Address with id: " +
                addressId + " does not exist", HttpStatus.NO_CONTENT);
    }
}

