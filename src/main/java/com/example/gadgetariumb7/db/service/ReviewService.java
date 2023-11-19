package com.example.gadgetariumb7.db.service;

import com.example.gadgetariumb7.dto.request.ReviewRequest;
import com.example.gadgetariumb7.dto.response.ReviewResponses;
import com.example.gadgetariumb7.dto.response.SimpleResponse;

import java.util.Map;

public interface ReviewService {

    ReviewResponses getAll(String statusOfReviews);

    Map<Integer, Integer> countReviewsGrade();

    SimpleResponse update(Long id, ReviewRequest reviewRequest);

    SimpleResponse deleteReviewById(Long id);

}