package com.isaenkobook.bookstore.controller;

import com.isaenkobook.bookstore.model.dto.CallbackFormReqDTO;
import com.isaenkobook.bookstore.service.CallbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CallbackController {
    private final CallbackService callbackService;

    @PostMapping("/callback")
    public String callback(@ModelAttribute("callback") CallbackFormReqDTO callbackFormReqDTO) {
        callbackService.createCallback(callbackFormReqDTO);
        return "redirect:/";
    }
}
