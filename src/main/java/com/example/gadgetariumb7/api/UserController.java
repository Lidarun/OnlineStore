package com.example.gadgetariumb7.api;

import com.example.gadgetariumb7.db.service.FeedbackService;
import com.example.gadgetariumb7.db.service.UserService;
import com.example.gadgetariumb7.dto.request.FeedbackRequest;
import com.example.gadgetariumb7.dto.request.ReviewSaveRequest;
import com.example.gadgetariumb7.dto.request.ReviewSingleRequest;
import com.example.gadgetariumb7.dto.response.SimpleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "User API")
public class UserController {
    private final UserService userService;
    private final FeedbackService feedbackService;

    @Operation(summary = "This method for save review", description = "This endpoint save review with array of images")
    @PostMapping("/review")
    @PreAuthorize("hasAuthority('Customer')")
    public SimpleResponse save(@RequestBody ReviewSaveRequest reviewSaveRequest) {
        return userService.addReview(reviewSaveRequest);
    }

    @Operation(summary = "To edit the review", description = "user could edit only his own review")
    @PutMapping("/review")
    @PreAuthorize("hasAuthority('Customer')")
    public SimpleResponse edit(@RequestBody ReviewSingleRequest reviewRequest) {
        return userService.editReview(reviewRequest);
    }

    @Operation(summary = "To delete the review", description = "user could delete only his own review")
    @DeleteMapping("/review")
    @PreAuthorize("hasAuthority('Customer')")
    public SimpleResponse delete(@RequestParam(name = "review") Long reviewId) {
        return userService.deleteReview(reviewId);
    }

    @Operation(summary = "To save the feedback", description = "user could leave the feedback")
    @PostMapping("/feedback")
    @PreAuthorize("hasAuthority('Customer')")
    public SimpleResponse saveFeedback(@RequestBody FeedbackRequest feedbackRequest) {
        return feedbackService.saveFeedback(feedbackRequest);
    }
}
