package com.example.gadgetariumb7.db.service;

import com.example.gadgetariumb7.dto.request.FeedbackRequest;
import com.example.gadgetariumb7.dto.response.SimpleResponse;

public interface FeedbackService {

    SimpleResponse saveFeedback(FeedbackRequest feedbackRequest);

}