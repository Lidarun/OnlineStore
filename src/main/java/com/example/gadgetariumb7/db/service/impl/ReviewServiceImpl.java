package com.example.gadgetariumb7.db.service.impl;

import com.example.gadgetariumb7.db.entity.Product;
import com.example.gadgetariumb7.db.entity.Review;
import com.example.gadgetariumb7.db.entity.User;
import com.example.gadgetariumb7.db.repository.ReviewRepository;
import com.example.gadgetariumb7.db.service.ReviewService;
import com.example.gadgetariumb7.dto.request.ReviewRequest;
import com.example.gadgetariumb7.dto.response.*;
import com.example.gadgetariumb7.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Override
    public ReviewResponses getAll(String statusOfReview) {
        ReviewResponses reviewResponses = new ReviewResponses();
        List<ReviewResponse> responses = null;
        if (statusOfReview.equals("Отвеченные")) {
            responses = reviewRepository.getAllReviewByStatusTrue();
        } else if (statusOfReview.equals("Неотвеченные")) {
            responses = reviewRepository.getAllReviewByStatusOfResponseFalse();
        } else if (statusOfReview.equals("Все отзывы")) {
            responses = reviewRepository.getAllByAdmin();
        }
        duplicateCode(responses);
        reviewResponses.setReviewResponses(responses);
        reviewResponses.setCountGrade(countReviewsGrade());
        reviewResponses.setCountReviewUnAnswered(reviewRepository.countReviewUnAnswered());
        log.info("successfully works the get all reviews method");
        return reviewResponses;
    }

    private void duplicateCode(List<ReviewResponse> answered) {
        for (ReviewResponse r : answered) {
            User user = reviewRepository.getUserReview(r.getId());
            UserResponse userResponse = new UserResponse(
                    user.getId(),
                    user.getFirstName(), user.getLastName(),
                    user.getEmail(),
                    user.getImage()
            );
            Product product = reviewRepository.getProductReview(r.getId());
            Review review = reviewRepository.findById(r.getId()).orElseThrow(() -> {
                log.error("Review not found");
                throw new NotFoundException("Review not found");
            });
            ProductReviewResponse productReviewResponse = new ProductReviewResponse(product);
            r.setProductReviewResponse(productReviewResponse);
            r.setUserResponse(userResponse);
            r.setReviewImages(review.getImages());
        }
        log.info("successfully works the duplicate code method");
    }

    @Override
    public Map<Integer, Integer> countReviewsGrade() {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 1; i < 6; i++) {
            counts.put(i, reviewRepository.countReviewByProductGrade(i));
        }
        log.info("successfully works the count reviews grade method");
        return counts;
    }

    @Override
    public SimpleResponse update(Long id, ReviewRequest reviewRequest) {
        Review review = reviewRepository.findById(id).orElseThrow(() -> {
            log.error("Not found");
            throw new NotFoundException(String.format("Not found"));
        });
        review.setResponseOfReview(reviewRequest.getResponseOfReview());
        review.setStatusOfResponse(review.getResponseOfReview().length() != 0);
        reviewRepository.save(review);
        log.info("successfully works the update method");
        return new SimpleResponse("Answer successfully saved", "ok");
    }

    @Override
    public SimpleResponse deleteReviewById(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(() -> {
            log.error("not found!");
            throw new NotFoundException(String.format("not found!"));
        });
        reviewRepository.delete(review);
        log.info("successfully works the delete review by id method");
        return new SimpleResponse("deleted", "ok");
    }
}
