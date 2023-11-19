package com.example.gadgetariumb7.api;

import com.example.gadgetariumb7.db.service.ProductService;
import com.example.gadgetariumb7.dto.request.ProductRequest;
import com.example.gadgetariumb7.dto.request.ProductUpdateRequest;
import com.example.gadgetariumb7.dto.response.InforgraphicsResponse;
import com.example.gadgetariumb7.dto.response.ProductAdminPaginationResponse;
import com.example.gadgetariumb7.dto.response.SimpleResponse;
import com.example.gadgetariumb7.exceptions.NotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/adminProducts")
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Product admin API")
@PreAuthorize("hasAuthority('Admin')")
public class ProductAdminController {

    private final ProductService productService;

    @Operation(summary = "Get all products to admin page", description = "This endpoint return all products by product type for ADMIN")
    @GetMapping()
    public ProductAdminPaginationResponse getAllProduct(
            @RequestParam String productType,
            @RequestParam(value = "searchText", required = false) String searchText,
            @RequestParam(value = "fieldToSort", required = false) String fieldToSort,
            @RequestParam(value = "discountField", required = false) String discountField,
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam int page,
            @RequestParam int size) {
        return productService.getProductAdminResponses(searchText, productType, fieldToSort, discountField, startDate, endDate, page, size);
    }

    @Operation(summary = "Delete product", description = "This endpoint delete product by id")
    @DeleteMapping
    public SimpleResponse delete(@RequestParam Long id) {
        return productService.delete(id);
    }

    @Operation(summary = "Update product", description = "This endpoint update product by id")
    @PutMapping
    public SimpleResponse update(@RequestBody ProductUpdateRequest productUpdateRequest) {
        return productService.update(productUpdateRequest);
    }

    @Operation(summary = "This method for save product",
            description = "The save product with different types and options")
    @PostMapping()
    public SimpleResponse save(@RequestBody ProductRequest productRequest) throws IOException {
        return productService.addProduct(productRequest);
    }

    @Operation(summary = "This method for get information", description = "Get information with product status")
    @GetMapping("/inf")
    public InforgraphicsResponse infographic() throws NotFoundException {
        return productService.infographics();
    }
}
