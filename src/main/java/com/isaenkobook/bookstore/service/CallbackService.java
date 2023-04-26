package com.isaenkobook.bookstore.service;

import com.isaenkobook.bookstore.model.dto.CallbackFormReqDTO;
import org.springframework.stereotype.Service;

@Service
public interface CallbackService {


    void createCallback(CallbackFormReqDTO callback);

    void updateCallback(Long authorId);

    boolean deleteAuthor(Long authorId);
}
