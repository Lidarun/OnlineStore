package com.example.gadgetariumb7.api;

import com.example.gadgetariumb7.db.service.impl.ReviewServiceImpl;
import com.example.gadgetariumb7.dto.request.ReviewRequest;
import com.example.gadgetariumb7.dto.response.ReviewResponses;
import com.example.gadgetariumb7.dto.response.SimpleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Review admin API")
@PreAuthorize("hasAuthority('Admin')")
public class ReviewController {
    private final ReviewServiceImpl reviewService;

    @Operation(summary = "Reviews", description = "Get all reviews")
    @GetMapping
    public ReviewResponses getAll(@RequestParam String statusOfReviews) {
        return reviewService.getAll(statusOfReviews);
    }

    @Operation(summary = "Delete", description = "Delete review by id")
    @DeleteMapping
    public SimpleResponse deleteById(@RequestParam Long id) {
        return reviewService.deleteReviewById(id);
    }

    @Operation(summary = "Answer and update", description = "Answer saved")
    @PutMapping
    public SimpleResponse updateReview(@RequestParam Long id, ReviewRequest reviewRequest) {
        return reviewService.update(id, reviewRequest);
    }
}
