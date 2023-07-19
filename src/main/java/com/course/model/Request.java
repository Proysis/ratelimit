package com.course.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Request {
    private int id;
    @Builder.Default
    private String destination = "Somewhere Else";
    @Builder.Default
    private String ip = "Somewhere is belongs to";
    private int userId;
}
