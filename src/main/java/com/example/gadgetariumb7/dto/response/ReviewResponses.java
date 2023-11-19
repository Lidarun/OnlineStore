package com.example.gadgetariumb7.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponses {

    private List<ReviewResponse> reviewResponses;

    private Map<Integer, Integer> countGrade;

    private int countReviewUnAnswered;

}
