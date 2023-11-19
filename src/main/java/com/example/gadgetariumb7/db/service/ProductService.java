package com.example.gadgetariumb7.db.service;

import com.example.gadgetariumb7.dto.response.*;
import com.example.gadgetariumb7.dto.request.ProductRequest;
import com.example.gadgetariumb7.dto.request.ProductUpdateRequest;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface ProductService {

    List<ProductCardResponse> getAllDiscountProductToMP(int page, int size);

    List<ProductCardResponse> getAllNewProductToMP(int page, int size);

    List<ProductCardResponse> getAllRecommendationProductToMP(int page, int size);

    ProductAdminPaginationResponse getProductAdminResponses(String searchText, String productType, String fieldToSort, String discountField, LocalDate startDate, LocalDate endDate, int page, int size);

    SimpleResponse addProduct(ProductRequest productRequest) throws IOException;

    InforgraphicsResponse infographics() throws NullPointerException;

    SimpleResponse delete(Long id);

    SimpleResponse update(ProductUpdateRequest productUpdateRequest);

    ProductSingleResponse getProductById(Long productId, String attribute, Integer size);

    List<ProductCardResponse> getViewedProducts();

    List<ColorResponse> colorCount(Long categoryId);

}