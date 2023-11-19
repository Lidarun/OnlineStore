package com.example.gadgetariumb7.db.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "subscriptions")
@Getter
@Setter
@NoArgsConstructor
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subscription_gen")
    @SequenceGenerator(name = "subscription_gen", sequenceName = "subscription_seq", allocationSize = 1)
    private Long id;
    private String email;
}
