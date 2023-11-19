package com.example.gadgetariumb7.dto.response;

import com.example.gadgetariumb7.db.enums.ProductStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class ProductAdminResponse {
    private Long id;
    private String productImage;
    private Long productVendorCode;
    private String productName;
    private int productCount;
    private int countSubproducts;
    private LocalDateTime createAt;
    private int productPrice;
    private int currentPrice;
    private int amountOfDiscount;
    private String dateOfIssue;
    @JsonIgnore
    private ProductStatus productStatus;

    public ProductAdminResponse(Long id, String productImage, Long productVendorCode, String productName, int productCount, int countSubproducts, LocalDateTime createAt, int productPrice, ProductStatus productStatus, String dateOfIssue) {
        this.id = id;
        this.productImage = productImage;
        this.productVendorCode = productVendorCode;
        this.productName = productName;
        this.productCount = productCount;
        this.countSubproducts = countSubproducts;
        this.createAt = createAt;
        this.productPrice = productPrice;
        this.productStatus = productStatus;
        this.dateOfIssue = dateOfIssue;
    }

    public ProductAdminResponse(Long id, String productImage, Long productVendorCode, String productName, int productCount, int countSubproducts, LocalDateTime createAt, int productPrice, ProductStatus productStatus) {
        this.id = id;
        this.productImage = productImage;
        this.productVendorCode = productVendorCode;
        this.productName = productName;
        this.productCount = productCount;
        this.countSubproducts = countSubproducts;
        this.createAt = createAt;
        this.productPrice = productPrice;
        this.productStatus = productStatus;
    }

}
