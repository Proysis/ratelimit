package com.course.service;

import com.course.model.Request;

public interface RateLimitService {
    boolean checkLimit(Request request);

    void forward(Request request);

    void drop(Request request);
}
