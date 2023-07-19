package com.course.service;

import com.course.Cache;
import com.course.runnable.TokenRunnable;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public record TokenTimeService(TokenService tokenService) implements TimeService{
    @Override
    public void onTime() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(new TokenRunnable(tokenService), 0, 5, TimeUnit.SECONDS);
    }
}
