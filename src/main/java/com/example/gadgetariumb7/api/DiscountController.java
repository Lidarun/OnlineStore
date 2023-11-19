package com.example.gadgetariumb7.api;

import com.example.gadgetariumb7.db.service.DiscountService;
import com.example.gadgetariumb7.dto.request.DiscountRequest;
import com.example.gadgetariumb7.dto.response.SimpleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/discounts")
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Discount API")
public class DiscountController {
    private final DiscountService discountService;

    @Operation(summary = "Add discount", description = "This endpoint adds a new discount")
    @PostMapping
    @PreAuthorize("hasAuthority('Admin')")
    public SimpleResponse addDiscount(@RequestBody DiscountRequest discountRequest) {
        return discountService.addDiscount(discountRequest);
    }
}
