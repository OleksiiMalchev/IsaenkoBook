package com.isaenkobook.bookstore.controller;

import com.isaenkobook.bookstore.model.dto.CustomerRespDTO;
import com.isaenkobook.bookstore.model.dto.PayReqDTO;
import com.isaenkobook.bookstore.service.CustomerService;
import com.isaenkobook.bookstore.service.PayService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PayController {
    private final PayService payService;

    @PostMapping("/pay")
    public String payOrder(@ModelAttribute("pay_order")PayReqDTO payReqDTO, HttpServletRequest request) {
        payService.createPay(payReqDTO);

        String referer = request.getHeader("referer");
        return "redirect:" + referer;
    }
}
