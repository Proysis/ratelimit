package com.course;

import com.course.model.Request;
import com.course.service.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Cache cache = new Cache();
        TokenService tokenService = new BucketTokenService(cache);
        TimeService timeService = new TokenTimeService(tokenService);
        timeService.onTime();

        RateLimitService rateLimitService = new BucketRateLimitService(tokenService);
        for (Request request : cache.getRequestsQueue()) {
            Thread.sleep(200L);
            if (rateLimitService.checkLimit(request)) {
                rateLimitService.forward(request);
                continue;
            }
            rateLimitService.drop(request);
        }
    }
}