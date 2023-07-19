package com.course;

import com.course.model.Request;

import java.text.MessageFormat;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Cache {
    private final Queue<Request> requestsQueue = new ConcurrentLinkedQueue<>();

    private int tokenCount;

    public Cache() {
        for (int i = 1; i < 1000; i++) {
            requestsQueue.add(Request.builder().id(i).userId(i % 5).build());
        }
        tokenCount = 200;
    }

    public Queue<Request> getRequestsQueue() {
        return requestsQueue;
    }

    public void addToken(int token) {
        this.tokenCount += token;
        System.out.println(MessageFormat.format("New token amount is {0} ", tokenCount));
    }

    public void spentToken(){
        tokenCount--;
        System.out.println(MessageFormat.format("Remained token is {0} ", tokenCount));
    }

    public int getTokenCount(){
        return tokenCount;
    }
}
