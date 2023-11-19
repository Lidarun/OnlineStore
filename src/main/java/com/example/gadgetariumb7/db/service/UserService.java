package com.example.gadgetariumb7.db.service;

import com.example.gadgetariumb7.dto.request.ReviewSaveRequest;
import com.example.gadgetariumb7.dto.request.ReviewSingleRequest;
import com.example.gadgetariumb7.dto.response.*;

import java.util.List;
import java.util.Map;


public interface UserService {

    SimpleResponse addAndRemoveToFavorites(Long productId);

    SimpleResponse addAndRemoveToCompares(Long productId);

    List<ProductCardResponse> getAllFavorites();

    SimpleResponse addToBasketList(int orderCount, Long subProductId);

    SimpleResponse deleteFromBasketList(List<Long> subProductsId);

    SimpleResponse moveToFavoriteList(List<Long> subProductsId);

    List<SubproductCardResponse> getAllFromBasketList();

    SimpleResponse addReview(ReviewSaveRequest request);

    List<ProductCompareResponse> getAllFromUserCompareProductList(Long categoryId, boolean isUnique, int size, int page);

    Map<String, Integer> countOfCompareList();

    SimpleResponse deleteFromCompareList(Long id);

    SimpleResponse cleanCompareProducts(Long id);

    SimpleResponse cleanFavoriteProducts();

    SimpleResponse editReview(ReviewSingleRequest reviewRequest);

    SimpleResponse deleteReview(Long id);

    List<CompareProductResponse> simpleGetAll();

}