package com.example.gadgetariumb7.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductUpdateRequest {
    private Long id;
    private List<SubproductUpdateRequest> subproductUpdateRequests;
}
