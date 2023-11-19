package com.example.gadgetariumb7.api;

import com.example.gadgetariumb7.db.service.UserService;
import com.example.gadgetariumb7.dto.response.SimpleResponse;
import com.example.gadgetariumb7.dto.response.SubproductCardResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/userBasket")
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "User basket API")
@PreAuthorize("isAuthenticated()")
public class UserBasketController {
    private final UserService userService;

    @Operation(summary = "Add product to basket list", description = "This endpoint adds a product to a user's basket list")
    @PostMapping
    public SimpleResponse addToBasketList(@RequestParam int orderCount,
                                          @RequestParam Long productId) {
        return userService.addToBasketList(orderCount, productId);
    }

    @Operation(summary = "Delete a product from basket list", description = "This endpoint delete a product to a user's basket list")
    @DeleteMapping
    public SimpleResponse delete(@RequestBody List<Long> productsId) {
        return userService.deleteFromBasketList(productsId);
    }

    @Operation(summary = "Get all products from users basket list", description = "This endpoint return products from users basket list")
    @GetMapping
    public List<SubproductCardResponse> getAllFromBasketList() {
        return userService.getAllFromBasketList();
    }

    @Operation(summary = "Move a subproduct from basket list to favorite list", description = "This endpoint move subproducts from user's basket list to favorite list")
    @PostMapping("/move")
    public SimpleResponse moveToFavoriteList(@RequestBody List<Long> productsId) {
        return userService.moveToFavoriteList(productsId);
    }
}
