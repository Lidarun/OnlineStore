package com.example.gadgetariumb7.dto.response;

import com.example.gadgetariumb7.db.entity.Product;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductReviewResponse {
    private Long id;
    private String image;
    private String name;
    private String brandName;
    private Long productVendorCode;

    public ProductReviewResponse(Product product) {
        this.id = product.getId();
        this.image = product.getProductImage();
        this.name = product.getProductName();
        this.brandName = product.getBrand().getBrandName();
        this.productVendorCode = product.getProductVendorCode();
    }

}
