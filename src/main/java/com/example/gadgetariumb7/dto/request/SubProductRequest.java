package com.example.gadgetariumb7.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubProductRequest {
    private int price;
    private int countOfProduct;
    private String color;
    private List<String> images;
    private Map<String, String> characteristics;
}
