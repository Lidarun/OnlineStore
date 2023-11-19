package com.example.gadgetariumb7.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubproductCardResponse {
    private Long id;
    private String productName;
    private String image;
    private Map<String, String> characteristics;
    private String color;
    private Double rating;
    private byte amountOfDiscount;
    private int countOfReviews;
    private int countOfSubproduct;
    private Long vendorCode;
    private int orderCount;
    private int price;

    public SubproductCardResponse(Long id, String productName, String image, Map<String, String> characteristics, String color, Double rating, int countOfReviews, int countOfSubproduct, Long vendorCode, int orderCount, int price) {
        this.id = id;
        this.productName = productName;
        this.image = image;
        this.characteristics = characteristics;
        this.color = color;
        this.rating = rating;
        this.countOfReviews = countOfReviews;
        this.countOfSubproduct = countOfSubproduct;
        this.vendorCode = vendorCode;
        this.orderCount = orderCount;
        this.price = price;
    }
}
