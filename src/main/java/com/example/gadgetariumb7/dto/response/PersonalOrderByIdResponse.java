package com.example.gadgetariumb7.dto.response;

import com.example.gadgetariumb7.db.enums.DeliveryStatus;
import com.example.gadgetariumb7.db.enums.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonalOrderByIdResponse {
    private int orderNumber;
    private List<ProductCardResponse> subproducts;
    private DeliveryStatus deliveryStatus;
    private String fullName;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;
    private LocalDate dateOfOrder;
    private Payment payment;
    private int discountPrice;
    private int totalSum;
}
