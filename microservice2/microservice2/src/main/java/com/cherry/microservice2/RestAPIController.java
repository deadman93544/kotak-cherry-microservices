package com.cherry.microservice2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAPIController {

    @GetMapping("/hello")
    public String getHelloWorld(){
        return "Hello World";
    }
}
