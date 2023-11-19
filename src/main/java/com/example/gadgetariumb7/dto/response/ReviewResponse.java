
package com.example.gadgetariumb7.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ReviewResponse {
    private Long id;
    private String userReview;
    private String responseOfReview;
    private List<String> reviewImages;
    private LocalDateTime reviewTime;
    private Double productGrade;

    private ProductReviewResponse productReviewResponse;

    private UserResponse userResponse;

    public ReviewResponse(Long id, String userReview, String responseOfReview, LocalDateTime reviewTime, Double productGrade) {
        this.id = id;
        this.userReview = userReview;
        this.responseOfReview = responseOfReview;
        this.reviewTime = reviewTime;
        this.productGrade = productGrade;
    }
}
