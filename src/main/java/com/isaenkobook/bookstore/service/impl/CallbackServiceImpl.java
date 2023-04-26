package com.isaenkobook.bookstore.service.impl;

import com.isaenkobook.bookstore.mapper.CallbackMapper;
import com.isaenkobook.bookstore.model.CallbackFrom;
import com.isaenkobook.bookstore.model.CallbackStatus;
import com.isaenkobook.bookstore.model.dto.CallbackFormReqDTO;
import com.isaenkobook.bookstore.repository.CallbackFormRepository;
import com.isaenkobook.bookstore.service.CallbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CallbackServiceImpl implements CallbackService {
    private final CallbackFormRepository callbackRepository;
    private final CallbackMapper callbackMapper;

    @Override
    public void createCallback(CallbackFormReqDTO callback) {
        CallbackFrom callbackFrom = callbackMapper.toCallback(callback);
        callbackFrom.setCallbackStatus(CallbackStatus.NEW);
        callbackRepository.save(callbackFrom);
    }

    @Override
    public void updateCallback(Long authorId) {

    }

    @Override
    public boolean deleteAuthor(Long authorId) {
        return false;
    }
}
