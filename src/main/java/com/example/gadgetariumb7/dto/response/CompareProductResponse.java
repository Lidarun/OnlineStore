package com.example.gadgetariumb7.dto.response;

import com.example.gadgetariumb7.db.entity.Product;
import lombok.*;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompareProductResponse {

    private Long id;
    private String productName;
    private String image;
    private int price;
    private int ProductCount;

    public CompareProductResponse(Product product) {
        this.id = product.getId();
        this.productName = product.getProductName();
        this.image = product.getProductImage();
        this.price = product.getProductPrice();
        this.ProductCount = product.getProductCount();
    }

}
