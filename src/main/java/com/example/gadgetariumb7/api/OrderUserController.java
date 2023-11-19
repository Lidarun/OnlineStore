package com.example.gadgetariumb7.api;

import com.example.gadgetariumb7.db.service.OrderService;
import com.example.gadgetariumb7.dto.request.OrderRequest;
import com.example.gadgetariumb7.dto.response.OrderCompleteResponse;
import com.example.gadgetariumb7.dto.response.UserAutofillResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/userOrders")
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Orders user API")
@PreAuthorize("hasAuthority('Customer')")
public class OrderUserController {

    private final OrderService orderService;

    @Operation(summary = "Autofill", description = "This method return user's information if user is authenticated")
    @GetMapping("/autofill")
    public UserAutofillResponse autofill() {
        return orderService.autofillUserInformation();
    }

    @Operation(summary = "Save", description = "This method for save order")
    @PostMapping
    public OrderCompleteResponse save(@RequestBody OrderRequest orderRequest) {
        return orderService.saveOrder(orderRequest);
    }
}
