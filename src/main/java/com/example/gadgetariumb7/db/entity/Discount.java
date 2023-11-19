package com.example.gadgetariumb7.db.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "discounts")
@Getter
@Setter
@NoArgsConstructor
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discount_gen")
    @SequenceGenerator(name = "discount_gen", sequenceName = "discount_seq", allocationSize = 1, initialValue = 11)
    private Long id;

    private Byte amountOfDiscount;

    private LocalDate discountStartDate;

    private LocalDate discountEndDate;

    @OneToMany(cascade = {MERGE, DETACH, REFRESH}, mappedBy = "discount")
    private List<Product> products;
}
