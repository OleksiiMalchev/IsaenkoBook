package com.isaenkobook.bookstore.controller;

import com.isaenkobook.bookstore.model.dto.CartItemRespDTO;
import com.isaenkobook.bookstore.model.dto.CustomerReqDTO;
import com.isaenkobook.bookstore.model.dto.CustomerRespDTO;
import com.isaenkobook.bookstore.service.CartService;
import com.isaenkobook.bookstore.service.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @Autowired
    private  CustomerService customerService;

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

    @GetMapping("/order")
    public String order(Model model, HttpServletRequest request) {
        return "order";
    }


    @PostMapping("/customers/submitForm")
    public ResponseEntity<? super CustomerRespDTO> createCustomer(@ModelAttribute("customer") CustomerReqDTO customerReqDTO) {
        if (customerReqDTO == null) {
            return new ResponseEntity<>("Request cannot be empty", HttpStatus.BAD_REQUEST);

        }
        CustomerRespDTO customer = customerService.createCustomer(customerReqDTO);
        return ResponseEntity.status(201).body(customer);
    }

}
