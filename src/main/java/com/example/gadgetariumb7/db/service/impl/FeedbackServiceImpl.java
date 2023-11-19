package com.example.gadgetariumb7.db.service.impl;

import com.example.gadgetariumb7.db.entity.Feedback;
import com.example.gadgetariumb7.db.repository.FeedbackRepository;
import com.example.gadgetariumb7.db.service.FeedbackService;
import com.example.gadgetariumb7.dto.request.FeedbackRequest;
import com.example.gadgetariumb7.dto.response.SimpleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepository feedbackRepository;

    @Override
    public SimpleResponse saveFeedback(FeedbackRequest feedbackRequest) {
        Feedback feedback = new Feedback();
        feedback.setEmail(feedbackRequest.getEmail());
        feedback.setFirstName(feedbackRequest.getFirstName());
        feedback.setLastName(feedbackRequest.getLastName());
        feedback.setPhoneNumber(feedbackRequest.getPhoneNumber());
        feedback.setText(feedbackRequest.getText());
        feedbackRepository.save(feedback);
        log.info("Successfully works the save feedback method");
        return new SimpleResponse(String.format("the feedback with %d id is saved ", feedback.getId()), "200");
    }
}
