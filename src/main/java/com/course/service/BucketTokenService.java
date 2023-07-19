package com.course.service;

import com.course.Cache;

public record BucketTokenService(Cache cache) implements TokenService{
    @Override
    public void addToken(int token) {
        cache.addToken(token);
    }

    @Override
    public void removeToken() {
        cache.spentToken();
    }

    @Override
    public int getTokenCount() {
        return cache().getTokenCount();
    }
}
