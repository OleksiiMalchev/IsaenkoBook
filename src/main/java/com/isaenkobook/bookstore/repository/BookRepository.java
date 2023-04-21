package com.isaenkobook.bookstore.repository;

import com.isaenkobook.bookstore.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
