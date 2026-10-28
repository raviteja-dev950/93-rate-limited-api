package com.ratelimiter.service;
import io.github.bucket4j.*;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RateLimitService {
    private final ConcurrentHashMap<String, Bucket> buckets = new ConcurrentHashMap<>();

    public boolean tryConsume(String key, int requests, int minutes) {
        Bucket bucket = buckets.computeIfAbsent(key, k -> {
            Bandwidth limit = Bandwidth.classic(requests, Refill.greedy(requests, Duration.ofMinutes(minutes)));
            return Bucket.builder().addLimit(limit).build();
        });
        return bucket.tryConsume(1);
    }
}