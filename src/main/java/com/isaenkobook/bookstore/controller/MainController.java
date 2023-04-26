package com.isaenkobook.bookstore.controller;

import com.isaenkobook.bookstore.service.CartService;
import com.isaenkobook.bookstore.service.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private ResourceBundleMessageSource messageSource;
    @Autowired
    private  CartService cartService;
    @Autowired
    private  CustomerService customerService;

    @GetMapping("/main")
    public String home(Model model, HttpServletRequest request) {
        return "main_new";
    }

    @GetMapping("/change-locale")
    public String changeLocale(@RequestParam("locale") String locale) {
        messageSource.setBasename(locale);
        return "redirect:/main";
    }

}
