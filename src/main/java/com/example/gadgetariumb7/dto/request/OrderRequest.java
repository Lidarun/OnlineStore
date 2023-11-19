package com.example.gadgetariumb7.dto.request;

import com.example.gadgetariumb7.db.enums.OrderType;
import com.example.gadgetariumb7.db.enums.Payment;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private int countOfProduct;
    private int totalSum;
    private int totalDiscount;
    private Payment payment;
    private OrderType orderType;
    private List<Long> subproductsId;
}
