package com.example.gadgetariumb7.db.repository;

import com.example.gadgetariumb7.db.entity.Order;
import com.example.gadgetariumb7.db.enums.OrderStatus;
import com.example.gadgetariumb7.dto.response.OrderResponse;
import com.example.gadgetariumb7.dto.response.PersonalOrderResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select new com.example.gadgetariumb7.dto.response.OrderResponse" +
            "(o.id," +
            "concat(o.firstName,' ', o.lastName ), " +
            "o.orderNumber," +
            "o.totalSum," +
            "o.countOfProduct," +
            "o.dateOfOrder," +
            "o.orderType," +
            "o.orderStatus) from Order o where o.orderStatus = :orderStatus")
    Page<OrderResponse> findAllOrdersByStatus(OrderStatus orderStatus, Pageable pageable);


    @Query("select count (o) from Order o where o.orderStatus = :orderStatus")
    Long countByOrderStatus(OrderStatus orderStatus);

    @Query("SELECT NEW com.example.gadgetariumb7.dto.response.OrderResponse" +
            "(o.id, " +
            "CONCAT(o.firstName, ' ', o.lastName), " +
            "o.orderNumber, " +
            "o.dateOfOrder, " +
            "o.countOfProduct, " +
            "o.totalSum, " +
            "o.orderType, " +
            "o.orderStatus) " +
            "FROM Order o " +
            "WHERE (o.orderStatus = :orderStatus) and  ((UPPER(CONCAT(o.firstName, ' ', o.lastName)) LIKE UPPER(CONCAT('%', :keyWord, '%'))) " +
            "OR (CAST(o.orderNumber AS string) LIKE CONCAT(:keyWord, '%')) " +
            "OR (UPPER(o.orderType) LIKE UPPER(CONCAT('%', :keyWord, '%'))))")
    Page<OrderResponse> search(@Param("keyWord") String keyWord, Pageable pageable, OrderStatus orderStatus);

    @Query("select new com.example.gadgetariumb7.dto.response.PersonalOrderResponse(" +
            "o.id," +
            "o.dateOfOrder," +
            "o.orderNumber," +
            "o.orderStatus," +
            "o.totalSum) from Order o where o.user.id = ?1")
    List<PersonalOrderResponse> getAllPersonalOrders(Long userId);
}

