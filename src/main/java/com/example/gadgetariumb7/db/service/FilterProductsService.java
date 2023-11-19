package com.example.gadgetariumb7.db.service;

import com.example.gadgetariumb7.dto.response.CatalogResponse;
import com.example.gadgetariumb7.exceptions.NotFoundException;

import java.util.List;

public interface FilterProductsService {

    CatalogResponse filterByParameters(String fieldToSort, String discountField, String categoryName, List<String> subCategoryName, Integer minPrice, Integer maxPrice, List<String> colors,
                                       List<Integer> memory, List<Byte> ram, List<String> laptopCPU, List<String> screenResolution, List<String> screenSize, List<String> screenDiagonal, List<String> batteryCapacity,
                                       List<String> wirelessInterface, List<String> caseShape, List<String> braceletMaterial, List<String> housingMaterial, List<String> gender, List<String> waterProof, int size) throws NotFoundException;

    CatalogResponse filterByParameters(String text, int size) throws NotFoundException;

}