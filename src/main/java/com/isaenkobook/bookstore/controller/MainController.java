package com.isaenkobook.bookstore.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@Controller
public class MainController {
    @GetMapping("/main")
    public String home(Model model, HttpServletRequest request) {
        Locale currentLocale = request.getLocale();
        String countryCode = currentLocale.getCountry();
        String countryName = currentLocale.getDisplayCountry();
        String language = currentLocale.getLanguage();
        String displayCountry = currentLocale.getDisplayCountry();

        System.out.println(countryCode + ":" + countryName);
        System.out.println(language + ":" + displayCountry);

        return "home";
    }
}
