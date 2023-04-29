package com.isaenkobook.bookstore.repository;

import com.isaenkobook.bookstore.model.BookMeta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMetaRepository extends CrudRepository<BookMeta,Long> {

    @Query("SELECT bm FROM BookMeta bm WHERE bm.article = :article AND bm.locale = :locale")
    BookMeta findByArticleAndLocale(@Param("article") String article, @Param("locale") String locale);




}
