package com.example.gadgetariumb7.api;

import com.example.gadgetariumb7.db.service.PersonalService;
import com.example.gadgetariumb7.dto.request.ChangePasswordRequest;
import com.example.gadgetariumb7.dto.request.UserUpdateRequest;
import com.example.gadgetariumb7.dto.response.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/personals")
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "User personal api")
public class PersonalController {
    private final PersonalService personalService;

    @Operation(summary = "This method for get all user's orders")
    @GetMapping("/orders")
    @PreAuthorize("isAuthenticated()")
    List<PersonalOrderResponse> orders() {
        return personalService.getAllPersonalOrders();
    }

    @Operation(summary = "This method for get by id user's order")
    @GetMapping("/getOrder")
    @PreAuthorize("isAuthenticated()")
    PersonalOrderByIdResponse getByIdOrder(@RequestParam Long orderId) {
        return personalService.getByIdPersonalOrder(orderId);
    }

    @Operation(summary = "This method for get all from user's favorite list")
    @GetMapping("/favorites")
    @PreAuthorize("isAuthenticated()")
    List<ProductCardResponse> getAllFavorites() {
        return personalService.getAllPersonalFavorite();
    }

    @Operation(summary = "This method for update user")
    @PutMapping("/updateUser")
    @PreAuthorize("isAuthenticated()")
    Object updateUserInfo(@RequestBody UserUpdateRequest userUpdateRequest) {
        return personalService.updateUser(userUpdateRequest);
    }

    @Operation(summary = "This method return user's personal information")
    @GetMapping("/userInfo")
    @PreAuthorize("isAuthenticated()")
    PersonalUserResponse getUserInfo() {
        return personalService.getPersonalUser();
    }

    @Operation(summary = "This method for clear user order history")
    @DeleteMapping()
    @PreAuthorize("isAuthenticated()")
    SimpleResponse clearOrderHistory() {
        return personalService.clearOrdersHistory();
    }

    @Operation(summary = "This method for change user's password")
    @PutMapping("/changePassword")
    @PreAuthorize("isAuthenticated()")
    SimpleResponse changePassword(@RequestBody ChangePasswordRequest changePasswordRequest) {
        return personalService.changePassword(changePasswordRequest);
    }
}
