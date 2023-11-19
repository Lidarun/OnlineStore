package com.example.gadgetariumb7.dto.response;

import com.example.gadgetariumb7.db.enums.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderPaymentResponse {

    private Long id;

    private String fullName;

    private int orderNumber;

    private int totalSum;

    private int countOfProduct;

    private double discount;

    private int totalDiscount;

    private List<String> productsName;

    private OrderStatus orderStatus;

    private int total;

    private String phoneNumber;

    private String address;

}
