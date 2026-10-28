package com.ratelimiter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.LinkedHashMap;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("project", "93-rate-limited-api");
        map.put("status", "Live - Rate Limited API");
        map.put("tier", "10 - System Design Level");
        map.put("owner", "Raviteja");
        map.put("endpoints", new String[]{"/api/data (5 req/min)", "/api/limited (2 req/min)"});
        map.put("live", "https://nine3-rate-limited-api.onrender.com");
        map.put("github", "https://github.com/raviteja-dev950/93-rate-limited-api");
        map.put("message", "Try /api/data 5 times, 6th gives 429 Too Many Requests");
        return map;
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("status", "UP");
        map.put("service", "93-rate-limited-api");
        map.put("rate-limiting", "Enabled");
        return map;
    }
}