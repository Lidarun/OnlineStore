package com.example.gadgetariumb7.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReviewSingleRequest {
    private Long id;
    private String userReview;
    private List<String> images;
    private Double productGrade;
}
