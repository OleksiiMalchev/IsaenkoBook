package com.isaenkobook.bookstore.controller;

import com.isaenkobook.bookstore.model.dto.CartItemRespDTO;
import com.isaenkobook.bookstore.service.CartService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Controller
public class MainController {

    @Autowired
    private ResourceBundleMessageSource messageSource;
    @Autowired
    private  CartService cartService;

    @GetMapping("/main")
    public String home(Model model, HttpServletRequest request) {
        return "main";
    }

    @GetMapping("/change-locale")
    public String changeLocale(@RequestParam("locale") String locale) {
        Set<String> basenameSet = messageSource.getBasenameSet();
        messageSource.setBasename(locale);
        return "redirect:/main";
    }

    @GetMapping("/shoppingCart")
    public String shoppingCartHandler(HttpServletRequest request, Model model) {
        List<CartItemRespDTO> cartItems = cartService.getCartItems();

        model.addAttribute("cartForm", cartItems);
        model.addAttribute("myCart", cartItems);
        return "shoppingCart";
    }
}
