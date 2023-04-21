package com.isaenkobook.bookstore.repository;

import com.isaenkobook.bookstore.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
