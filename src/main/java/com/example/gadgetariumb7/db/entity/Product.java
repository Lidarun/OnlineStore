package com.example.gadgetariumb7.db.entity;

import com.example.gadgetariumb7.db.enums.ProductStatus;

import javax.persistence.*;

import com.example.gadgetariumb7.dto.request.ProductRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_gen")
    @SequenceGenerator(name = "product_gen", sequenceName = "product_seq", allocationSize = 1, initialValue = 24)
    private Long id;

    private String productName;

    private int productPrice;

    private Long productVendorCode;

    private int productCount;

    private byte guarantee;

    @Column(length = 10000)
    private String videoReview;

    @Column(length = 10000)
    private String PDF;

    @Column(length = 10000)
    private String description;

    private ProductStatus productStatus;

    private Double productRating;

    private LocalDateTime createAt;

    private String color;

    private String dateOfIssue;

    @ManyToOne(cascade = {DETACH, MERGE, REFRESH})
    private Discount discount;

    @ManyToOne(cascade = {DETACH, REFRESH, MERGE})
    private Brand brand;

    @ManyToOne(cascade = {DETACH, REFRESH, MERGE})
    private Category category;

    @ManyToOne(cascade = {DETACH, REFRESH, MERGE})
    private Subcategory subCategory;

    @Column(length = 1000000)
    private String productImage;

    @OneToMany(cascade = {DETACH, MERGE, REFRESH, REMOVE}, mappedBy = "product")
    List<Review> usersReviews;

    @OneToMany(cascade = {ALL}, mappedBy = "product")
    List<Subproduct> subproducts;

    public Product(ProductRequest productRequest, List<Subproduct> subproducts, Brand brand, Category category, Subcategory subCategory) {
        this.brand = brand;
        this.category = category;
        this.subCategory = subCategory;
        this.productName = productRequest.getProductName();
        this.productVendorCode = productRequest.getProductVendorCode();
        this.guarantee = productRequest.getGuarantee();
        this.videoReview = productRequest.getVideoReview();
        this.PDF = productRequest.getPDF();
        this.description = productRequest.getDescription();
        this.productCount = subproducts.get(0).getCountOfSubproduct();
        this.productImage = subproducts.get(0).getImages().get(0);
        this.color = subproducts.get(0).getColor();
        this.productPrice = subproducts.get(0).getPrice();
    }
}



