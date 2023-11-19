package com.example.gadgetariumb7.db.entity;

import javax.persistence.*;

import com.example.gadgetariumb7.dto.request.SubProductRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "subproducts")
@Getter
@Setter
@NoArgsConstructor
public class Subproduct {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subproduct_gen")
    @SequenceGenerator(name = "subproduct_gen", sequenceName = "subproduct_seq", allocationSize = 1, initialValue = 43)
    private Long id;
    private int price;
    private int countOfSubproduct;
    private String color;

    @ElementCollection
    @CollectionTable(name = "characteristics_subproduct", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "characteristics_value")
    private Map<String, String> characteristics = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "subproduct_images", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "image_url", length = 1000000)
    List<String> images;

    @ManyToOne(cascade = {DETACH, MERGE, PERSIST, REFRESH}, fetch = FetchType.EAGER)
    private Product product;

    @ManyToMany(cascade = {MERGE, REFRESH, DETACH})
    @JoinTable(
            name = "orders_subproducts",
            joinColumns = @JoinColumn(name = "subproduct_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Order> orders;

    public Subproduct(SubProductRequest subProductRequest) {
        this.characteristics = subProductRequest.getCharacteristics();
        this.color = subProductRequest.getColor();
        this.images = subProductRequest.getImages();
        this.price = subProductRequest.getPrice();
        this.countOfSubproduct = subProductRequest.getCountOfProduct();
    }
}

