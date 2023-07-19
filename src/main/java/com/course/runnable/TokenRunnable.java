package com.course.runnable;

import com.course.service.TokenService;

public record TokenRunnable(TokenService tokenService) implements Runnable{
    @Override
    public void run() {
        tokenService.addToken(10);
    }
}
