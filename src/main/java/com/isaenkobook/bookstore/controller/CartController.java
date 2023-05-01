package com.isaenkobook.bookstore.controller;

import com.isaenkobook.bookstore.model.dto.CartItemRespDTO;
import com.isaenkobook.bookstore.model.dto.CartRespDTO;
import com.isaenkobook.bookstore.service.CartService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("/cart")
    public String getCart(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        List<CartItemRespDTO> cartItems = cartService.getCartItems();
        String totalPrice = cartService.getTotalPrice();
        session.setAttribute("totalPrice", totalPrice);
        session.setAttribute("cartItems", cartItems);
        String referer = request.getHeader("referer");
        return "redirect:" + referer;
    }





    @PostMapping("/add-to-cart")
    public String addItem(@RequestParam("id") Long bookId, @RequestParam(value = "quantity", required = false, defaultValue = "1") Integer quantity,
                          HttpServletRequest request) {
        cartService.addItem(bookId, quantity);
        return "redirect:" + request.getHeader("Referer");

    }
//
//    @PostMapping("/carts/update")
//    public ResponseEntity<?super CartRespDTO> updateItem(@RequestBody CartItemReqDTO cartItemReqDTO) {
//        cartService.updateItem(cartItemReqDTO);
//        return getCart();
//    }
//
//    @PostMapping("/carts/remove")
//    public ResponseEntity<?super CartRespDTO> removeItem(@RequestBody CartItemReqDTO cartItemReqDTO) {
//        cartService.removeItem(cartItemReqDTO.getBookId());
//        return getCart();
//    }
//
    @PostMapping("/carts/clear")
    public String clearCart(HttpServletRequest request) {
        cartService.clearCart();
        String referer = request.getHeader("referer");
        return "redirect:" + referer;
    }
}
