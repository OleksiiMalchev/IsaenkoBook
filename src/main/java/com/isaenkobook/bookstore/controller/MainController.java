package com.isaenkobook.bookstore.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
public class MainController {

    @Autowired
    ResourceBundleMessageSource messageSource;

    @GetMapping("/main")
    public String home(Model model, HttpServletRequest request) {
        return "home";
    }

    @GetMapping("/change-locale")
    public String changeLocale(@RequestParam("locale") String locale) {
        Set<String> basenameSet = messageSource.getBasenameSet();
        messageSource.setBasename(locale);
        return "redirect:/main";
    }
}
