package com.ratelimiter.interceptor;
import com.ratelimiter.annotation.RateLimit;
import com.ratelimiter.service.RateLimitService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RateLimitInterceptor implements HandlerInterceptor {
    private final RateLimitService service;
    public RateLimitInterceptor(RateLimitService service) {
        this.service = service;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;
            RateLimit limit = hm.getMethodAnnotation(RateLimit.class);
            if (limit != null) {
                String key = request.getHeader("X-Client-Id");
                if (key == null) key = request.getRemoteAddr();
                if (!service.tryConsume(key, limit.requests(), limit.minutes())) {
                    response.setStatus(429);
                    response.getWriter().write("429 Too Many Requests - Try after 1 minute");
                    return false;
                }
            }
        }
        return true;
    }
}