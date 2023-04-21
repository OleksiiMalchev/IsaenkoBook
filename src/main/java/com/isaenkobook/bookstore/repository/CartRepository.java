//package com.isaenkobook.bookstore.repository;
//
//import com.isaenkobook.bookstore.model.Book;
//import org.springframework.context.annotation.Scope;
//import org.springframework.context.annotation.ScopedProxyMode;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.math.BigDecimal;
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
//public class CartRepository {
//
//    private Map<Long, Book> items = new HashMap<>();
//    public void addItem(Long bookId) {
//        if (items.containsKey(bookId)) {
//            items.put(bookId, items.get(bookId) + 1);
//        } else {
//            items.put(bookId, 1);
//        }
//    }
//
//    public void removeItem(Long bookId) {
//        if (items.containsKey(bookId)) {
//            int count = items.get(bookId);
//            if (count == 1) {
//                items.remove(bookId);
//            } else {
//                items.put(bookId, count - 1);
//            }
//        }
//    }
//
//    public Map<Long, Integer> getItems() {
//        return items;
//    }
//
//    public BigDecimal getTotal() {
//        BigDecimal total = BigDecimal.ZERO;
//        for (Map.Entry<Book, Integer> entry : items.entrySet()) {
//            Book book = entry.getKey();
//            int count = entry.getValue();
//            total = total.add(book.getPrice().multiply(BigDecimal.valueOf(count)));
//        }
//        return total;
//    }
//
//    public void clear() {
//        items.clear();
//    }
//}
