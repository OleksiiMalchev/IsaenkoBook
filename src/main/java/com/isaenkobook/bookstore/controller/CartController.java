package com.isaenkobook.bookstore.controller;

import com.isaenkobook.bookstore.model.dto.AuthorRespDTO;
import com.isaenkobook.bookstore.model.dto.CartItemReqDTO;
import com.isaenkobook.bookstore.model.dto.CartItemRespDTO;
import com.isaenkobook.bookstore.model.dto.CartRespDTO;
import com.isaenkobook.bookstore.service.CartService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("/cart")
    public String getCart(Model model, HttpServletRequest request) {
        List<CartItemRespDTO> cartItems = cartService.getCartItems();
        String totalPrice = cartService.getTotalPrice();
        String referer = request.getHeader("Referer");
        if(cartItems.isEmpty()){
            model.addAttribute("check", "No item in your cart");
        } else {
            model.addAttribute("totalPrice",totalPrice);
            model.addAttribute("cartItems",cartItems);
        }
        return "redirect:"+referer;
    }

    @PostMapping("/add-to-cart")
    public String addItem( @RequestParam("id") Long bookId,@RequestParam(value = "quantity", required = false, defaultValue = "1") Integer quantity,
                           HttpServletRequest request) {
        //Long bookId = Long.valueOf(bookIdSrt);

        cartService.addItem(bookId,quantity);
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
//    @PostMapping("/carts/clear")
//    public ResponseEntity<?super CartRespDTO> clearCart() {
//        cartService.clearCart();
//        return getCart();
//    }
}
