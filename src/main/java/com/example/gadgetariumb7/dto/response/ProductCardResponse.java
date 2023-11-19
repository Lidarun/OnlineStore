package com.example.gadgetariumb7.dto.response;

import com.example.gadgetariumb7.db.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCardResponse {
    private Long productId;
    private List<Long> firstSubproductId;
    private String productImage;
    private String productName;
    private int count;
    private int productPrice;
    private int discountPrice;
    private ProductStatus productStatus;
    private Double productRating;
    private int countOfReview;
    private boolean isFavorite;
    private boolean isCompared;
    private boolean isViewed;
    private byte categoryId;

    public ProductCardResponse(Long productId, String productImage, String productName, int count, int productPrice, ProductStatus productStatus, Double productRating) {
        this.productId = productId;
        this.productImage = productImage;
        this.productName = productName;
        this.count = count;
        this.productPrice = productPrice;
        this.productStatus = productStatus;
        this.productRating = productRating;
    }

    public ProductCardResponse(Long productId, String productName, String productImage, Double productRating, int productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productImage = productImage;
        this.productRating = productRating;
        this.productPrice = productPrice;
    }

    public ProductCardResponse(Long productId, String productName, String productImage, Double productRating, int countOfReview, int productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productImage = productImage;
        this.productRating = productRating;
        this.countOfReview = countOfReview;
        this.productPrice = productPrice;
        isViewed = true;
    }

    public ProductCardResponse(Long productId, String productImage, String productName, int count, int productPrice, ProductStatus productStatus, Double productRating, byte categoryId) {
        this.productId = productId;
        this.productImage = productImage;
        this.productName = productName;
        this.count = count;
        this.productPrice = productPrice;
        this.productStatus = productStatus;
        this.productRating = productRating;
        this.categoryId = categoryId;
    }
}
