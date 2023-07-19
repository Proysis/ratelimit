package com.course.runnable;

import com.course.Cache;

public record TokenRunnable(Cache cache) implements Runnable{
    @Override
    public void run() {
        cache.addToken(10);
    }
}
