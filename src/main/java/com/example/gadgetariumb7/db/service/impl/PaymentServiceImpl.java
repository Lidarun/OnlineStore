package com.example.gadgetariumb7.db.service.impl;

import com.example.gadgetariumb7.db.service.PaymentService;
import com.example.gadgetariumb7.dto.request.PaymentRequest;
import com.example.gadgetariumb7.dto.response.SimpleResponse;
import com.example.gadgetariumb7.exceptions.BadRequestException;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Event;
import com.stripe.net.Webhook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {
    @Value("${stripe.apiKey}")
    private String apiKey;

    @Value("${stripe.webhook.secret}")
    private String webhookSecret;

    @Override
    public SimpleResponse chargeCreditCard(PaymentRequest paymentRequest) {
        try {
            Stripe.apiKey = apiKey;
            Map<String, Object> chargeParams = new HashMap<>();
            int amount = (int) Math.round(paymentRequest.getAmount() * 100);
            chargeParams.put("amount", amount);
            chargeParams.put("currency", paymentRequest.getCurrency());
            chargeParams.put("source", paymentRequest.getToken());
            Charge.create(chargeParams);
            log.info("successfully the charge credit card method works ");
            return new SimpleResponse("Payment successful!", "200");
        } catch (StripeException e) {
            log.error("Something wrong with token");
            return new SimpleResponse(e.getMessage(), "404");
        }
    }

    @Override
    public SimpleResponse handleWebhookEvent(String payload, String signatureHeader) {
        try {
            Webhook.Signature.verifyHeader(payload, signatureHeader, webhookSecret, 300);
            Event event = Webhook.constructEvent(payload, signatureHeader, webhookSecret);
            log.info("Event created");
            switch (event.getType()) {
                case "charge.succeeded" -> {
                    log.info("Charge succeeded");
                    return new SimpleResponse("Payment succeed", "ok");
                }
                case "charge.failed" -> {
                    log.info("Charge failed");
                    return new SimpleResponse("Payment failed", "катострофа");
                }
                case "charge.refunded" -> {
                    log.info("Charge refunded");
                    return new SimpleResponse("Payment refunded", "ok");
                }
                default -> {
                    log.info("Event error");
                    return new SimpleResponse("Something went wrong", "катострофа");
                }
            }
        } catch (StripeException e) {
            log.info("Event error");
            throw new BadRequestException(e.getMessage());
        }
    }
}