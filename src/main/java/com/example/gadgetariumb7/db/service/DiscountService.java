package com.example.gadgetariumb7.db.service;

import com.example.gadgetariumb7.dto.request.DiscountRequest;
import com.example.gadgetariumb7.dto.response.SimpleResponse;

public interface DiscountService {

    SimpleResponse addDiscount(DiscountRequest discountRequest);

}