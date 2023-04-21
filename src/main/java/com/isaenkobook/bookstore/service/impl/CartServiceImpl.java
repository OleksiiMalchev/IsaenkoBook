package com.isaenkobook.bookstore.service.impl;

import com.isaenkobook.bookstore.model.Cart;
import com.isaenkobook.bookstore.model.dto.BookRespDTO;
import com.isaenkobook.bookstore.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final Cart cart;


    @Override
    public void addItem(Long bookId) {


    }

    @Override
    public void removeItem(Long bookId) {

    }

    @Override
    public Map<BookRespDTO, Integer> getItems() {
        return null;
    }

    @Override
    public BigDecimal getTotal() {
        return null;
    }

    @Override
    public void clear() {

    }
}
