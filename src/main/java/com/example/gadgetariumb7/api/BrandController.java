package com.example.gadgetariumb7.api;

import com.example.gadgetariumb7.db.service.BrandService;
import com.example.gadgetariumb7.dto.request.BrandRequest;
import com.example.gadgetariumb7.dto.response.BrandResponse;
import com.example.gadgetariumb7.dto.response.SimpleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/brands")
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Brand API")
@PreAuthorize("hasAuthority('Admin')")
public class BrandController {

    private final BrandService brandService;

    @Operation(summary = "Get all brands", description = "This endpoint returns a list of all brands")
    @GetMapping
    public List<BrandResponse> getAllBrand() {
        return brandService.getAllBrand();
    }

    @Operation(summary = "Add a brand", description = "This endpoint adds a new brand")
    @PostMapping
    public SimpleResponse addBrand(@RequestBody BrandRequest brandRequest) {
        return brandService.addBrand(brandRequest);
    }
}
