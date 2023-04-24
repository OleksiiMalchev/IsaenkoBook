package com.isaenkobook.bookstore.repository;

import com.isaenkobook.bookstore.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AuthorRepository extends CrudRepository<Author,Long> {
    @Override
    List<Author> findAll();
}
