package com.cherry.assignment.views;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogRequest implements Request{
    private String uid;

    private String message;
}
