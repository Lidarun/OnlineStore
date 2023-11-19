package com.example.gadgetariumb7.db.service;

import com.example.gadgetariumb7.db.enums.OrderStatus;
import com.example.gadgetariumb7.dto.request.OrderRequest;
import com.example.gadgetariumb7.dto.response.*;

import java.time.LocalDate;

public interface OrderService {

    PaginationOrderResponse findAllOrders(OrderStatus orderStatus, String keyWord, int page, int size, LocalDate startDate, LocalDate endDate);

    SimpleResponse deleteOrderById(Long id);

    UserAutofillResponse autofillUserInformation();

    OrderCompleteResponse saveOrder(OrderRequest orderRequest);

    SimpleResponse update(Long id, OrderStatus orderStatus);

    OrderPaymentResponse getOrdersPaymentInfo(Long id);

}
