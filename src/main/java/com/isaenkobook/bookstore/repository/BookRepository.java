package com.isaenkobook.bookstore.repository;

import com.isaenkobook.bookstore.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    @Override
    List<Book> findAll();

    @Query("SELECT book FROM Book book WHERE book.title = :title")
    List<Book> findByTitle(@Param("title") String title);
}
