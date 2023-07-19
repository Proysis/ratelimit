package com.course;

import com.course.model.Request;
import com.course.service.BucketRateLimitService;
import com.course.service.RateLimitService;
import com.course.service.TimeService;
import com.course.service.TokenTimeService;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Cache cache = new Cache();
        TimeService timeService = new TokenTimeService(cache);
        timeService.onTime();

        RateLimitService rateLimitService = new BucketRateLimitService(cache);
        for (Request request : new Cache().getRequestsQueue()) {
            Thread.sleep(200L);
            if (rateLimitService.checkLimit(request)) {
                rateLimitService.forward(request);
                continue;
            }
            rateLimitService.drop(request);
        }
    }
}