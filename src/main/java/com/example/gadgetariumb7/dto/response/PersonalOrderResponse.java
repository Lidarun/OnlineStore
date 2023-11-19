package com.example.gadgetariumb7.dto.response;

import com.example.gadgetariumb7.db.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonalOrderResponse {
    private Long id;
    private LocalDateTime dateOfOrder;
    private int orderNumber;
    private OrderStatus orderStatus;
    private int totalSum;
}
