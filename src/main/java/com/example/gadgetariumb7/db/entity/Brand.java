package com.example.gadgetariumb7.db.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "brands")
@Getter
@Setter
@NoArgsConstructor
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brand_gen")
    @SequenceGenerator(name = "brand_gen", sequenceName = "brand_seq", allocationSize = 1, initialValue = 6)
    private Long id;

    private String brandName;

    @Column(length = 10000)
    private String image;
}
