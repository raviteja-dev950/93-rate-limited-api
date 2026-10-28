package com.ratelimiter.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RateLimitServiceTest {
    private final RateLimitService service = new RateLimitService();

    @Test
    public void testAllow5Requests() {
        String key = "test-client";
        for(int i=0; i<5; i++) {
            assertTrue(service.tryConsume(key, 5, 1));
        }
    }

    @Test
    public void testBlock6thRequest() {
        String key = "test-client-2";
        for(int i=0; i<5; i++) service.tryConsume(key, 5, 1);
        assertFalse(service.tryConsume(key, 5, 1));
    }
}