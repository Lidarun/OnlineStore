package com.example.gadgetariumb7.api;

import com.example.gadgetariumb7.db.enums.OrderStatus;
import com.example.gadgetariumb7.db.service.OrderService;
import com.example.gadgetariumb7.dto.response.OrderPaymentResponse;
import com.example.gadgetariumb7.dto.response.PaginationOrderResponse;
import com.example.gadgetariumb7.dto.response.SimpleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/adminOrders")
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Orders admin API")
@PreAuthorize("hasAuthority('Admin')")
public class OrderAdminController {

    private final OrderService orderService;

    @Operation(summary = "Find all", description = "Orders with pagination and search")
    @GetMapping
    public PaginationOrderResponse findAllOrders(@RequestParam OrderStatus orderStatus,
                                                 @RequestParam(required = false) String keyWord,
                                                 @RequestParam int page,
                                                 @RequestParam int size,
                                                 @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                 @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return orderService.findAllOrders(orderStatus, keyWord, page, size, startDate, endDate);
    }

    @Operation(summary = "Delete order by id")
    @DeleteMapping
    public SimpleResponse deleteOrder(@RequestParam Long id) {
        return orderService.deleteOrderById(id);
    }

    @Operation(summary = "Update order by orderStatus", description = "In this method we can update orders by order status")
    @PutMapping
    public SimpleResponse update(@RequestParam Long id,
                                 @RequestParam(value = "orderStatus", required = false) OrderStatus orderStatus) {
        return orderService.update(id, orderStatus);
    }

    @Operation(summary = "Get by id order payment info", description = "In this method we can get  order payment info(total sum,total discount, discount) and user address,phone number")
    @GetMapping("/paymentInfo")
    public OrderPaymentResponse getOrderPaymentInfo(@RequestParam(value = "orderId") Long id) {
        return orderService.getOrdersPaymentInfo(id);
    }

}
