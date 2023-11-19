package com.example.gadgetariumb7.db.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_gen")
    @SequenceGenerator(name = "review_gen", sequenceName = "review_seq", allocationSize = 1, initialValue = 6)
    private Long id;

    private LocalDateTime reviewTime;

    private Double productGrade;

    @Column(length = 10000)
    private String userReview;

    @Column(length = 10000)
    private String responseOfReview;

    private boolean statusOfResponse;

    @ElementCollection
    @CollectionTable(name = "review_images", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "image_url", length = 10000)
    private List<String> images;

    @ManyToOne(cascade = {DETACH, MERGE, REFRESH})
    private User user;

    @ManyToOne(cascade = {DETACH, MERGE, REFRESH})
    private Product product;

    public Review(Double productGrade, String userReview, User user, Product product) {
        this.productGrade = productGrade;
        this.userReview = userReview;
        this.user = user;
        this.product = product;
    }
}
