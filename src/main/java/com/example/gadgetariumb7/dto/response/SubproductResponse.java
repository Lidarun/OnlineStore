package com.example.gadgetariumb7.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubproductResponse {
    private Long id;
    private int price;
    private int countOfSubproduct;
    private String colorName;
    private String colorCode;
    private Map<String, String> characteristics = new HashMap<>();
    private List<String> images;

    public SubproductResponse(Long id, int countOfSubproduct, List<String> images, int price, String colorName, String colorCode, Map<String, String> characteristics) {
        this.id = id;
        this.price = price;
        this.countOfSubproduct = countOfSubproduct;
        this.colorName = colorName;
        this.colorCode = colorCode;
        this.characteristics = characteristics;
        this.images = images;
    }
}
