package com.example.gadgetariumb7.api;

import com.example.gadgetariumb7.db.service.PaymentService;
import com.example.gadgetariumb7.dto.request.PaymentRequest;
import com.example.gadgetariumb7.dto.response.SimpleResponse;
import com.stripe.exception.StripeException;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Payment API")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/charge")
    @PreAuthorize("isAuthenticated()")
    public SimpleResponse chargeCreditCard(@RequestBody PaymentRequest paymentRequest) throws StripeException {
        return paymentService.chargeCreditCard(paymentRequest);
    }

    @PostMapping("/webhook")
    public SimpleResponse handleWebhookEvent(@RequestBody String payload, @RequestParam String signatureHeader) {
        return paymentService.handleWebhookEvent(payload, signatureHeader);
    }
}
