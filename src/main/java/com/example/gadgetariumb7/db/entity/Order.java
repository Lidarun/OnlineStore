package com.example.gadgetariumb7.db.entity;

import com.example.gadgetariumb7.db.enums.DeliveryStatus;
import com.example.gadgetariumb7.db.enums.OrderStatus;
import com.example.gadgetariumb7.db.enums.OrderType;

import com.example.gadgetariumb7.db.enums.Payment;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_gen")
    @SequenceGenerator(name = "order_gen", sequenceName = "order_seq", allocationSize = 1, initialValue = 55)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String address;

    private int countOfProduct;

    private int totalSum;

    private int totalDiscount;

    private int orderNumber;

    private LocalDateTime dateOfOrder;

    @Enumerated(EnumType.STRING)
    private OrderType orderType;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    private Payment payment;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    @ManyToOne(cascade = {DETACH, MERGE, REFRESH})
    private User user;

    @ManyToMany(cascade = {MERGE, DETACH, REFRESH}, mappedBy = "orders")
    private List<Subproduct> subproducts;


    public Order(String firstName, String lastName, String email, String phoneNumber, String address, int countOfProduct, int totalSum, int totalDiscount, Payment payment, OrderType orderType, List<Subproduct> subproducts, User user, int orderNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.countOfProduct = countOfProduct;
        this.totalSum = totalSum;
        this.totalDiscount = totalDiscount;
        this.payment = payment;
        this.subproducts = subproducts;
        this.orderStatus = OrderStatus.IN_PROCESSING;
        this.orderType = orderType;
        this.deliveryStatus = DeliveryStatus.IN_PROCESS;
        this.dateOfOrder = LocalDateTime.now();
        this.user = user;
        this.orderNumber = orderNumber;
    }
}
