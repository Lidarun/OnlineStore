package com.example.gadgetariumb7.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class ProductRequest {
    @NotNull(message = "Product name should be not null")
    @NotBlank(message = "Product name should be not blank")
    private String productName;

    @NotNull(message = "Product vendor code should be not null")
    @NotBlank(message = "Product vendor code should be not blank")
    private Long productVendorCode;

    @NotNull(message = "Product guarantee should be not null")
    @NotBlank(message = "Product guarantee should be not blank")
    private byte guarantee;

    @NotNull(message = "Product video review should be not null")
    @NotBlank(message = "Product video review should be not blank")
    private String videoReview;

    @NotNull(message = "Product pdf should be not null")
    @NotBlank(message = "Product pdf should be not blank")
    private String PDF;

    @NotNull(message = "Product description should be not null")
    @NotBlank(message = "Product description should be not blank")
    private String description;

    @NotNull(message = "Brand id should be not null")
    @NotBlank(message = "Brand id should be not blank")
    private Long brandId;

    @NotNull(message = "Category id should be not null")
    @NotBlank(message = "Category id should be not blank")
    private Long categoryId;

    @NotNull(message = "Subcategory id should be not null")
    @NotBlank(message = "Subcategory id should be not blank")
    private Long subCategoryId;

    @NotNull(message = "Subproducts should be not null")
    @NotBlank(message = "Subproducts should be not blank")
    private List<SubProductRequest> subProductRequests;

    @NotNull(message = "Product datOfIssue should be not null")
    @NotBlank(message = "Product datOfIssue should be not blank")
    private String dateOfIssue;
}
