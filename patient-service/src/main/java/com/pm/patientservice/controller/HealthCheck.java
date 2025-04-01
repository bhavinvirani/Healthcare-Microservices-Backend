package com.pm.patientservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @GetMapping("/health-check")
    public String healthCheck() {
        // Constructor logic can be added here if needed
        // For now, just return a simple message
        return "OK";
    }
}
