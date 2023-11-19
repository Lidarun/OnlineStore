package com.example.gadgetariumb7.db.service.impl;

import com.example.gadgetariumb7.db.entity.Brand;
import com.example.gadgetariumb7.db.repository.BrandRepository;
import com.example.gadgetariumb7.db.service.BrandService;
import com.example.gadgetariumb7.dto.request.BrandRequest;
import com.example.gadgetariumb7.dto.response.BrandResponse;
import com.example.gadgetariumb7.dto.response.SimpleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    @Override
    public SimpleResponse addBrand(BrandRequest brandRequest) {
        Brand brand = new Brand();
        brand.setBrandName(brandRequest.getBrandName());
        brand.setImage(brandRequest.getImage());
        brandRepository.save(brand);
        log.info("successfully works the add brand method");
        return new SimpleResponse("Brand successfully saved!", "ok");
    }

    @Override
    public List<BrandResponse> getAllBrand() {
        log.info("successfully works the get all brand method");
        return brandRepository.findAll().stream().map(brand -> new BrandResponse(brand.getId(), brand.getImage(), brand.getBrandName())).collect(Collectors.toList());
    }

}
