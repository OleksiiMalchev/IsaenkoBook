package com.isaenkobook.bookstore.controller;

import com.isaenkobook.bookstore.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
}
