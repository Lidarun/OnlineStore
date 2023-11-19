package com.example.gadgetariumb7.db.service;

import com.example.gadgetariumb7.dto.request.PaymentRequest;
import com.example.gadgetariumb7.dto.response.SimpleResponse;
import com.stripe.exception.StripeException;

public interface PaymentService {

    SimpleResponse chargeCreditCard(PaymentRequest paymentRequest) throws StripeException;

    SimpleResponse handleWebhookEvent(String payload, String signatureHeader);

}