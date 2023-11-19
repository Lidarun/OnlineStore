package com.example.gadgetariumb7.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewMainResponse {
    private Long id;
    private String userReview;
    private boolean isMyReview;
    private String responseOfReview;
    private LocalDateTime reviewTime;
    private Double productGrade;
    private UserMainResponse userMainResponse;

    public ReviewMainResponse(Long id, String userReview, String responseOfReview, LocalDateTime reviewTime, Double productGrade, UserMainResponse userMainResponse) {
        this.id = id;
        this.userReview = userReview;
        this.responseOfReview = responseOfReview;
        this.reviewTime = reviewTime;
        this.productGrade = productGrade;
        this.userMainResponse = userMainResponse;
    }
}
