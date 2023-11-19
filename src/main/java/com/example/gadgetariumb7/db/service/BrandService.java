package com.example.gadgetariumb7.db.service;

import com.example.gadgetariumb7.dto.request.BrandRequest;
import com.example.gadgetariumb7.dto.response.BrandResponse;
import com.example.gadgetariumb7.dto.response.SimpleResponse;

import java.util.List;

public interface BrandService {

    SimpleResponse addBrand(BrandRequest brandRequest);

    List<BrandResponse> getAllBrand();

}
