package com.example.gadgetariumb7.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductAdminPaginationResponse {
    private int pages;
    private int currentPage;
    private List<ProductAdminResponse> responseList;
}
