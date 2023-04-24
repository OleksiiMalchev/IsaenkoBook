package com.isaenkobook.bookstore.service;

import com.isaenkobook.bookstore.model.dto.BookRespDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
@Service
public interface CartService {
    void addItem(Long bookId);

    void removeItem(Long bookId);

    Map<BookRespDTO, Integer> getItems();

    BigDecimal getTotal();

    void clear();
}
