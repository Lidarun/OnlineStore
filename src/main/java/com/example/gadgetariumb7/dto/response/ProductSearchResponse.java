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
public class ProductSearchResponse {
    private Long id;
    private List<Long> firstSubproductId;
    private String productName;
    private String productImage;
    private int productCount;
    private int productPrice;
    private int discountPrice;
    private ProductStatus productStatus;
    private Double productRating;
    private int countOfReview;
    private boolean isFavorite;
    private boolean isCompared;

    private String brandName;
    private String categoryName;
    private String subCategoryName;
    private Byte amountOfDiscount;
    private String description;
    private Long productVendorCode;
    private String color;
    private Long categoryId;

    public ProductSearchResponse(Long id, String productImage, String productName, int productCount, int productPrice, ProductStatus productStatus, Double productRating,
                                 String brandName, String categoryName, String subCategoryName, Byte amountOfDiscount,
                                 String description, Long productVendorCode, String color, Long categoryId) {
        this.id = id;
        this.productImage = productImage;
        this.productName = productName;
        this.productCount = productCount;
        this.productPrice = productPrice;
        this.productStatus = productStatus;
        this.productRating = productRating;
        this.brandName = brandName;
        this.categoryName = categoryName;
        this.subCategoryName = subCategoryName;
        this.amountOfDiscount = amountOfDiscount;
        this.description = description;
        this.productVendorCode = productVendorCode;
        this.color = color;
        this.categoryId = categoryId;
    }
}

