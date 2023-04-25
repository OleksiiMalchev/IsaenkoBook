package com.isaenkobook.bookstore.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class OrderDetailsReqDTO {

    private Long orderId;
    private List<Long> bookId;
    private List<Integer> quantity;

}
