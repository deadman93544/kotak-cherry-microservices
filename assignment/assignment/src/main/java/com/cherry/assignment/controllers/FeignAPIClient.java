package com.cherry.assignment.controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "MICRO-SERVICE-1", url = "http://localhost:8080")
public interface FeignAPIClient {
    @GetMapping(value = "/hello")
    String generateMessage();
}
