package com.isaenkobook.bookstore.mapper;

import com.isaenkobook.bookstore.model.CallbackFrom;
import com.isaenkobook.bookstore.model.dto.CallbackFormReqDTO;
import org.springframework.stereotype.Component;

@Component
public class CallbackMapper {
    public CallbackFrom toCallback(CallbackFormReqDTO callbackFormReqDTO) {
        return CallbackFrom.builder()
                .name(callbackFormReqDTO.getName())
                .email(callbackFormReqDTO.getEmail())
                .message(callbackFormReqDTO.getMessage())
                .build();
    }
}
