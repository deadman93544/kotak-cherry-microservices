package com.cherry.microservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class Microservice2Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Microservice2Application.class, args);
	}

}
