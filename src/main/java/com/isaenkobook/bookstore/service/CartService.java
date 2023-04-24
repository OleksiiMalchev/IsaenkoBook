package com.isaenkobook.bookstore.service;

import com.isaenkobook.bookstore.model.CartItem;
import com.isaenkobook.bookstore.model.dto.CartItemReqDTO;
import com.isaenkobook.bookstore.model.dto.CartItemRespDTO;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public interface CartService {
    void addItem(CartItemReqDTO cartItemRequestDTO);

    void updateItem(CartItemReqDTO cartItemRequestDTO);
    String getTotalPrice();

    void removeItem(Long bookId);

    List<CartItemRespDTO> getCartItems();

    void clearCart();

    void orderFormation();


}
