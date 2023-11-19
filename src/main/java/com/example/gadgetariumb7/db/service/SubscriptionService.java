package com.example.gadgetariumb7.db.service;

import com.example.gadgetariumb7.db.entity.Subscription;
import com.example.gadgetariumb7.dto.request.SubscriptionRequest;
import com.example.gadgetariumb7.dto.response.SimpleResponse;

import java.util.List;

public interface SubscriptionService {

    SimpleResponse save(SubscriptionRequest subscriptionRequest);

    List<Subscription> findAll();

    void sendEmail(Subscription subscription);

}