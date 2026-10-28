package com.ratelimiter.controller;
import com.ratelimiter.annotation.RateLimit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    @RateLimit(requests = 5, minutes = 1)
    @GetMapping("/data")
    public ResponseEntity<String> getData() {
        return ResponseEntity.ok("Success - You have 5 requests per minute");
    }

    @RateLimit(requests = 2, minutes = 1)
    @GetMapping("/limited")
    public ResponseEntity<String> getLimited() {
        return ResponseEntity.ok("This API allows only 2 requests per minute");
    }
}