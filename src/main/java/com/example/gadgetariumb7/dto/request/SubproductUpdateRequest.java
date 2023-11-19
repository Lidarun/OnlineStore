package com.example.gadgetariumb7.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubproductUpdateRequest {
    private Long id;
    private int subproductCount;
    private int price;
}
