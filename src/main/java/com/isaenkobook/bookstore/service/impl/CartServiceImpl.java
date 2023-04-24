package com.isaenkobook.bookstore.service.impl;

import com.isaenkobook.bookstore.mapper.CartItemMapper;
import com.isaenkobook.bookstore.model.Book;
import com.isaenkobook.bookstore.model.CartItem;
import com.isaenkobook.bookstore.model.dto.CartItemReqDTO;
import com.isaenkobook.bookstore.model.dto.CartItemRespDTO;
import com.isaenkobook.bookstore.repository.BookRepository;
import com.isaenkobook.bookstore.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final Map<Long, CartItem> cartItems = new HashMap<>();
    private final BookRepository bookRepository;
    private final CartItemMapper cartItemMapper;


    @Override
    public void addItem(CartItemReqDTO cartItemRequestDTO) {
        if (bookRepository.existsById(cartItemRequestDTO.getBookId())) {
            Book book = bookRepository.findById(cartItemRequestDTO.getBookId()).get();
            CartItem cartItem = cartItems.getOrDefault(book.getId(), CartItem.builder().book(book).quantity(0).build());
            cartItem.setQuantity(cartItem.getQuantity() + cartItemRequestDTO.getQuantity());
            cartItems.put(book.getId(), cartItem);
        }else {
            throw new NoSuchElementException("Item not found in cart.");
        }
    }

    @Override
    public void updateItem(CartItemReqDTO cartItemRequestDTO) {
        if (bookRepository.existsById(cartItemRequestDTO.getBookId())) {
            Book book = bookRepository.findById(cartItemRequestDTO.getBookId()).get();
            CartItem cartItem = cartItems.getOrDefault(book.getId(), CartItem.builder().book(book).quantity(0).build());
            cartItem.setQuantity(cartItemRequestDTO.getQuantity());
            if (cartItem.getQuantity() == 0) {
                cartItems.remove(book.getId());
            } else {
                cartItems.put(book.getId(), cartItem);
            }
        }else {
            throw new NoSuchElementException("Item not found in cart.");
        }
    }

    @Override
    public void removeItem(Long bookId) {
        cartItems.remove(bookId);
    }

    @Override
    public void clearCart() {
        cartItems.clear();
    }

    @Override
    public List<CartItemRespDTO> getCartItems() {
        return cartItems.values().stream().map(cartItemMapper::toCartItemRespDTO).toList();
    }

    @Override
    public String getTotalPrice() {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (CartItem cartItem : cartItems.values()) {
            totalPrice = totalPrice.add(cartItem.getBook().getPrice().multiply(new BigDecimal(cartItem.getQuantity())));
        }
        return totalPrice.setScale(2, RoundingMode.HALF_UP).toString();
    }

    @Override
    public void orderFormation() {

    }
}
