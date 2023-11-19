package com.example.gadgetariumb7.dto.response;

import com.example.gadgetariumb7.db.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class PaginationOrderResponse {
    private int currentPage;
    private int totalPage;
    private List<OrderResponse> orderResponses;
    private Map<OrderStatus, Long> orderStatusAndSize;
    private Long countOfOrders;
}
