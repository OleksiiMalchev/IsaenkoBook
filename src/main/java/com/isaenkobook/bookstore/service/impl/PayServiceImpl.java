package com.isaenkobook.bookstore.service.impl;

import com.isaenkobook.bookstore.model.CustomerAddress;
import com.isaenkobook.bookstore.model.OrderDetails;
import com.isaenkobook.bookstore.model.dto.CartItemRespDTO;
import com.isaenkobook.bookstore.model.dto.CustomerAddressRespDTO;
import com.isaenkobook.bookstore.model.dto.CustomerRespDTO;
import com.isaenkobook.bookstore.model.dto.OrderRespDTO;
import com.isaenkobook.bookstore.model.dto.PayReqDTO;
import com.isaenkobook.bookstore.model.dto.PayRespDTO;
import com.isaenkobook.bookstore.service.CartService;
import com.isaenkobook.bookstore.service.CustomerAddressService;
import com.isaenkobook.bookstore.service.CustomerService;
import com.isaenkobook.bookstore.service.OrderDetailsService;
import com.isaenkobook.bookstore.service.OrderService;
import com.isaenkobook.bookstore.service.PayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PayServiceImpl implements PayService {
    private final CustomerService customerService;
    private final CustomerAddressService customerAddressService;
    private final OrderService orderService;
    private final OrderDetailsService orderDetailsService;
    private final CartService cartService;

    @Override
    @Transactional
    public PayRespDTO createPay(PayReqDTO payReqDTO) {
        CustomerRespDTO customer = customerService.createCustomer(payReqDTO);
        Long customerId = customer.getCustomerId();
        CustomerAddressRespDTO customerAddress = customerAddressService.createCustomerAddress(payReqDTO, customerId);
        OrderRespDTO order = orderService.createOrder(customerId);
        List<CartItemRespDTO> cartItems = cartService.getCartItems();
        String totalPrice = cartService.getTotalPrice();
        orderDetailsService.createOrderDetails(order.getId(),cartItems);
        return PayRespDTO.builder().orderId(order.getId()).totalPrice(totalPrice).build();
    }
}
