package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HealthController {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot it's my first REST API!";
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }
}
