package com.isaenkobook.bookstore.controller;

import com.isaenkobook.bookstore.model.dto.AuthorRespDTO;
import com.isaenkobook.bookstore.model.dto.CartItemReqDTO;
import com.isaenkobook.bookstore.model.dto.CartItemRespDTO;
import com.isaenkobook.bookstore.model.dto.CartRespDTO;
import com.isaenkobook.bookstore.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("/carts")
    public ResponseEntity<?super CartRespDTO> getCart() {
        List<CartItemRespDTO> cartItems = cartService.getCartItems();
        String totalPrice = cartService.getTotalPrice();
        return cartItems.isEmpty() ? new ResponseEntity<>("Items not found", HttpStatus.NOT_FOUND) :
                ResponseEntity.status(200).body(CartRespDTO.builder().cartItems(cartItems).totalPrice(totalPrice));
    }

    @PostMapping("/carts/add")
    public ResponseEntity<?super CartRespDTO> addItem(@RequestBody CartItemReqDTO cartItemReqDTO) {
        cartService.addItem(cartItemReqDTO);
        return getCart();
    }

    @PostMapping("/carts/update")
    public ResponseEntity<?super CartRespDTO> updateItem(@RequestBody CartItemReqDTO cartItemReqDTO) {
        cartService.updateItem(cartItemReqDTO);
        return getCart();
    }

    @PostMapping("/carts/remove")
    public ResponseEntity<?super CartRespDTO> removeItem(@RequestBody CartItemReqDTO cartItemReqDTO) {
        cartService.removeItem(cartItemReqDTO.getBookId());
        return getCart();
    }

    @PostMapping("/carts/clear")
    public ResponseEntity<?super CartRespDTO> clearCart() {
        cartService.clearCart();
        return getCart();
    }
}
