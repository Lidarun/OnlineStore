package com.example.gadgetariumb7.db.service.impl;

import com.example.gadgetariumb7.db.entity.Order;
import com.example.gadgetariumb7.db.entity.Subproduct;
import com.example.gadgetariumb7.db.entity.User;
import com.example.gadgetariumb7.db.entity.Product;
import com.example.gadgetariumb7.db.enums.OrderStatus;
import com.example.gadgetariumb7.db.repository.OrderRepository;
import com.example.gadgetariumb7.db.repository.SubproductRepository;
import com.example.gadgetariumb7.db.repository.UserRepository;
import com.example.gadgetariumb7.db.service.MailingService;
import com.example.gadgetariumb7.db.service.OrderService;
import com.example.gadgetariumb7.dto.response.*;
import com.example.gadgetariumb7.dto.request.OrderRequest;
import com.example.gadgetariumb7.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final SubproductRepository subproductRepository;
    private final MailingService mailingService;
    private int orderGenerateNumber = 100006;

    private Optional<User> getAuthenticateUserForAutofill() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();
        log.info("successfully works the get authenticate user for autofill method");
        return userRepository.findByEmail(login);
    }

    @Override
    public PaginationOrderResponse findAllOrders(OrderStatus orderStatus, String keyWord, int page, int size, LocalDate startDate, LocalDate endDate) {
        List<OrderResponse> orderResponses;
        Page<OrderResponse> orderResponsesPagination;
        PaginationOrderResponse paginationOrderResponse = new PaginationOrderResponse();
        Pageable pageable = PageRequest.of(page - 1, size);

        if (keyWord == null) {
            orderResponsesPagination = orderRepository.findAllOrdersByStatus(orderStatus, pageable);
            orderResponses = orderResponsesPagination.getContent();
        } else {
            orderResponsesPagination = orderRepository.search(keyWord, pageable, orderStatus);
            orderResponses = orderResponsesPagination.getContent();
        }
        try {
            if (startDate != null && endDate != null) {
                orderResponses = orderResponses.stream().filter(o -> o.getDateOfOrder().toLocalDate().isAfter(startDate.minusDays(1)) && o.getDateOfOrder().toLocalDate()
                        .isBefore(endDate.plusDays(1))).toList();
            }
        } catch (DateTimeParseException ex) {
            log.error(String.format("Invalid date format %s", ex));
            throw new IllegalArgumentException("Invalid date format", ex);
        }
        paginationOrderResponse.setOrderResponses(orderResponses);
        paginationOrderResponse.setCurrentPage(pageable.getPageNumber() + 1);
        paginationOrderResponse.setTotalPage(orderResponsesPagination.getTotalPages());

        Map<OrderStatus, Long> getOrdersByStatus = new HashMap<>();
        getOrdersByStatus.put(OrderStatus.WAITING, orderRepository.countByOrderStatus(OrderStatus.WAITING));
        getOrdersByStatus.put(OrderStatus.IN_PROCESSING, orderRepository.countByOrderStatus(OrderStatus.IN_PROCESSING));
        getOrdersByStatus.put(OrderStatus.ON_THE_WAY, orderRepository.countByOrderStatus(OrderStatus.ON_THE_WAY));
        getOrdersByStatus.put(OrderStatus.DELIVERED, orderRepository.countByOrderStatus(OrderStatus.DELIVERED));
        getOrdersByStatus.put(OrderStatus.CANCEL, orderRepository.countByOrderStatus(OrderStatus.CANCEL));

        paginationOrderResponse.setOrderStatusAndSize(getOrdersByStatus);
        paginationOrderResponse.setCountOfOrders((long) orderRepository.findAll().size());
        log.info("successfully works the find all orders method");
        return paginationOrderResponse;
    }

    public SimpleResponse deleteOrderById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> {
            log.error("Order not found");
            throw new NotFoundException("Order not found");
        });
        if (order.getUser() != null) {
            order.getUser().getOrders().remove(order);
        }
        List<Subproduct> subproducts = order.getSubproducts();
        if (subproducts != null) {
            subproducts.forEach(x -> x.getOrders().remove(order));
        }
        orderRepository.delete(order);
        log.info("successfully works the delete order by id method");
        return new SimpleResponse("Order successfully deleted!", "ok");
    }

    @Override
    public SimpleResponse update(Long id, OrderStatus orderStatus) {
        Order order = orderRepository.findById(id).orElseThrow(() -> {
            log.error("Order for update not found");
            throw new NotFoundException("Order for update not found!");
        });
        if (orderStatus != null) order.setOrderStatus(orderStatus);
        orderRepository.save(order);
        log.info("successfully works the order update method");
        mailingService.sendEmail(order.getEmail().strip(), order);
        return new SimpleResponse("Order successfully updated", "ok");
    }

    @Override
    public OrderPaymentResponse getOrdersPaymentInfo(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> {
            log.error("Order not found");
            throw new NotFoundException("Order  not found!");
        });
        OrderPaymentResponse orderPaymentResponse = new OrderPaymentResponse();
        orderPaymentResponse.setId(order.getId());
        orderPaymentResponse.setFullName(order.getFirstName() + " " + order.getLastName());
        orderPaymentResponse.setOrderNumber(order.getOrderNumber());
        orderPaymentResponse.setCountOfProduct(order.getCountOfProduct());
        orderPaymentResponse.setTotalSum(order.getTotalSum());
        orderPaymentResponse.setTotalDiscount(order.getTotalDiscount());
        double discount1 = Math.round(((double) order.getTotalDiscount() * 100) / (double) order.getTotalSum());
        orderPaymentResponse.setDiscount(discount1);
        orderPaymentResponse.setTotal(order.getTotalSum() - order.getTotalDiscount());
        orderPaymentResponse.setAddress(order.getUser().getAddress());
        orderPaymentResponse.setPhoneNumber(order.getUser().getPhoneNumber());
        List<String> productsName = new ArrayList<>();
        List<Long> products = new ArrayList<>();
        order.getSubproducts().forEach(s -> {
            Product p = s.getProduct();
            if (!products.contains(p.getId())) {
                products.add(p.getId());
                productsName.add(p.getProductName());
            }
        });
        orderPaymentResponse.setProductsName(productsName);
        orderPaymentResponse.setOrderStatus(order.getOrderStatus());
        log.info("successfully works the get orders payment info method");
        return orderPaymentResponse;
    }


    @Override
    public UserAutofillResponse autofillUserInformation() {
        if (getAuthenticateUserForAutofill().isPresent()) {
            User user = getAuthenticateUserForAutofill().get();
            log.info("successfully works the autofill user information method");
            UserAutofillResponse userAutofillResponse = new UserAutofillResponse(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber(), user.getAddress());
            if (user.getAddress() == null)
                userAutofillResponse.setAddress("");
            return userAutofillResponse;
        } else {
            log.error("User is not authenticate");
            throw new NotFoundException("User is not authenticate");
        }
    }

    @Override
    public OrderCompleteResponse saveOrder(OrderRequest req) {
        User user = getAuthenticateUserForAutofill().orElseThrow(() -> {
            log.error("User not found");
            throw new NotFoundException("User not found");
        });
        List<Subproduct> subproducts = req.getSubproductsId().stream().map(s -> subproductRepository.findById(s).orElseThrow(() -> {
            log.error(String.format("Subproduct with id %d not found", s));
            throw new NotFoundException(String.format("Subproduct with id %d not found", s));
        })).toList();
        Order order = new Order(req.getFirstName(), req.getLastName(), req.getEmail(), req.getPhoneNumber(), req.getAddress(), req.getCountOfProduct(), req.getTotalSum(), req.getTotalDiscount(), req.getPayment(), req.getOrderType(), subproducts, user, orderGenerateNumber);
        order.setOrderStatus(OrderStatus.WAITING);
        user.getBasketList().forEach((key, value) -> key.setCountOfSubproduct(key.getCountOfSubproduct() - value));

        subproducts.forEach(x -> {
            if (user.getBasketList().containsKey(x))
                user.getBasketList().remove(x);
            else {
                log.error(String.format("Subproduct with id %d not exist in user's basket list with id %d", x.getId(), user.getId()));
                throw new NotFoundException(String.format("Subproduct with id %d not exist in user's basket list with id %d", x.getId(), user.getId()));
            }
        });
        orderGenerateNumber++;
        user.getOrderHistoryList().addAll(order.getSubproducts().stream().map(Subproduct::getProduct).distinct().toList());
        orderRepository.save(order);
        log.info("successfully works the save order method");
        mailingService.sendEmail(order.getEmail().strip(), order);
        return new OrderCompleteResponse(order.getOrderNumber(), order.getDateOfOrder());
    }
}

