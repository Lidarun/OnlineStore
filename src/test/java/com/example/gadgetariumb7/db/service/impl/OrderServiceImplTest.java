package com.example.gadgetariumb7.db.service.impl;

import com.example.gadgetariumb7.db.entity.Order;
import com.example.gadgetariumb7.db.entity.Product;
import com.example.gadgetariumb7.db.entity.Subproduct;
import com.example.gadgetariumb7.db.entity.User;
import com.example.gadgetariumb7.db.enums.OrderStatus;
import com.example.gadgetariumb7.db.repository.OrderRepository;
import com.example.gadgetariumb7.dto.response.OrderPaymentResponse;
import com.example.gadgetariumb7.dto.response.SimpleResponse;
import com.example.gadgetariumb7.exceptions.NotFoundException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {
    @Mock
   private OrderRepository orderRepository;
    @InjectMocks
   private OrderServiceImpl orderService;

    @Test
    void testDeleteOrderById() {
        // given
        Long orderId = 1L;
        Order order = new Order();
       order.setId(orderId);
        User user = new User(1L,"Test","Test");
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        user.setOrders(orders);
        Subproduct subproduct = mock(Subproduct.class);
        List<Subproduct> subproducts = new ArrayList<>();
        subproducts.add(subproduct);
        order.setSubproducts(subproducts);
        when(subproduct.getOrders()).thenReturn(orders);

        when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));

        // when
        SimpleResponse result = orderService.deleteOrderById(orderId);

        // then
        verify(orderRepository).delete(order);
        assertEquals(orders, user.getOrders()); // verify that the order was removed from the user's orders
       verify(subproduct).getOrders();
        assertEquals("Order successfully deleted!", result.getMessage());
        assertEquals("ok", result.getStatus());
    }

    @Test
    void deleteOrderById_shouldThrowNotFoundException() {
        // Given
        Long orderId = 1L;

        // When
        when(orderRepository.findById(orderId)).thenReturn(Optional.empty());

        // Then
        assertThrows(NotFoundException.class, () -> orderService.deleteOrderById(orderId));
        verify(orderRepository, never()).delete(any(Order.class));
    }


    @Test
    void update() {
        // given
        Long orderId = 1L;
        Order order = new Order();
        order.setId(orderId);
        OrderStatus newStatus = OrderStatus.WAITING;
        when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));

        // when
        SimpleResponse result = orderService.update(orderId, newStatus);

        // then
        verify(orderRepository).save(order);
        assertEquals(newStatus, order.getOrderStatus());
        assertEquals("Order successfully updated", result.getMessage());
        assertEquals("ok", result.getStatus());
    }

    @Test
    void getOrdersPaymentInfo() {
        Long orderId = 1L;
        Order order = new Order();
        order.setId(orderId);
        order.setFirstName("Almaz");
        order.setLastName("Aitnazarov");
        order.setOrderNumber(1256);
        order.setCountOfProduct(2);
        order.setTotalSum(100);
        order.setTotalDiscount(10);

        User user = new User(1L, "Test", "Test");
        user.setAddress("Shopokova 55");
        user.setPhoneNumber("123-456-7890");
        order.setUser(user);

        List<Subproduct> subproducts = new ArrayList<>();
        Subproduct subproduct = new Subproduct();
        subproduct.setId(1L);

        Product product = new Product();
        product.setId(1L);
        product.setProductName("TestProduct");
        subproduct.setProduct(product);
        subproducts.add(subproduct);

        order.setSubproducts(subproducts);
        order.setOrderStatus(OrderStatus.WAITING);

        when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));

        // when
        OrderPaymentResponse result = orderService.getOrdersPaymentInfo(orderId);

        // then
        assertEquals(orderId, result.getId());
        assertEquals("Almaz Aitnazarov", result.getFullName());
        assertEquals(1256, result.getOrderNumber());
        assertEquals(2, result.getCountOfProduct());
        assertEquals(100, result.getTotalSum());
        assertEquals(10, result.getTotalDiscount());
        assertEquals(10, result.getDiscount());
        assertEquals(90, result.getTotal());
        assertEquals("Shopokova 55", result.getAddress());
        assertEquals("123-456-7890", result.getPhoneNumber());
        List<String> productsName = new ArrayList<>();
        productsName.add("TestProduct");
        assertEquals(productsName, result.getProductsName());
        assertEquals(OrderStatus.WAITING, result.getOrderStatus());
    }
}