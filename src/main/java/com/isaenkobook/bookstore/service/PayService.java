package com.isaenkobook.bookstore.service;

import com.isaenkobook.bookstore.model.dto.OrderRespDTO;
import com.isaenkobook.bookstore.model.dto.PayReqDTO;
import com.isaenkobook.bookstore.model.dto.PayRespDTO;

public interface PayService {
    PayRespDTO createPay(PayReqDTO payReqDTO);
}
