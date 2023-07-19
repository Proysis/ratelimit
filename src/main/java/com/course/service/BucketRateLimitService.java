package com.course.service;

import com.course.Cache;
import com.course.model.Request;

import java.text.MessageFormat;

public record BucketRateLimitService(Cache cache) implements RateLimitService{
    @Override
    public boolean checkLimit(Request request) {
        return cache.getTokenCount() > 0;
    }

    @Override
    public void forward(Request request) {
        cache.spentToken();
        System.out.println(MessageFormat.format("Request {0} is forwarded to {1}", request.getId(), request.getDestination()));
    }

    @Override
    public void drop(Request request) {
        System.out.println(MessageFormat.format("Request {0} is dropped", request.getId()));
    }
}
