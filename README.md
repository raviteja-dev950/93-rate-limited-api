# 🚀 Project 93 – Rate Limited API | System Design Level | Full Stack DevOps

[Java 17](https://img.shields.io/badge/Java-17-E76F00?logo=openjdk&logoColor=white)
[Spring Boot 3.2.5](https://img.shields.io/badge/Spring%20Boot-3.2.5-6DB33F?logo=springboot&logoColor=white)
[Bucket4j](https://img.shields.io/badge/Bucket4j-8.7.0-00BFFF?logo=java&logoColor=white)
[Rate Limiting](https://img.shields.io/badge/Rate%20Limiting-Enabled-FF0000?logo=awswaf&logoColor=white)
[429 Handling](https://img.shields.io/badge/429-Too%20Many%20Requests-FF0000)
[JUnit 5](https://img.shields.io/badge/JUnit-5-25A162?logo=junit5&logoColor=white)
[Mockito](https://img.shields.io/badge/Mockito-Ready-00BFFF)
[Redis Ready](https://img.shields.io/badge/Redis-Ready-DC382D?logo=redis&logoColor=white)
[Interceptor](https://img.shields.io/badge/Interceptor-Pattern-FFA500?logo=spring&logoColor=white)
[Maven](https://img.shields.io/badge/Maven-3.9+-C71A36?logo=apachemaven&logoColor=white)
[Tomcat](https://img.shields.io/badge/Apache%20Tomcat-10.1.20-D4AF00?logo=apachetomcat&logoColor=white)
[Port](https://img.shields.io/badge/Port-8095-00BFFF)
[Status](https://img.shields.io/badge/Status-Rate%20Limit%20Live-brightgreen)
[Tier 10](https://img.shields.io/badge/Tier%2010-System%20Design%20Level-blueviolet)

**Live URL:** https://nine3-rate-limited-api.onrender.com/

[[Live](https://img.shields.io/badge/Live-Render-brightgreen?style=for-the-badge&logo=render)](https://nine3-rate-limited-api.onrender.com)

Project 93 - Part of Java 102 Projects Challenge - System Design Level Tier 10 START
---
**TIER 10 START 93/102**
---

# 📖 Project Overview

**Rate Limited API** is Project 93 of **Tier 10 – System Design Level – FIRST PROJECT OF TIER 10**, developed using **Java 17**, **Spring Boot 3.2.5**, **Bucket4j 8.7.0 Token Bucket**, **Interceptor Pattern**, **Custom Annotation @RateLimit**, **ConcurrentHashMap Caching**, **JUnit 5 + Mockito**, **Redis Ready**, **Maven**, and **Apache Tomcat 10.1.20** in a **production System Design ready repo**.

Spring Boot REST API running on port 8095 with 2 Rate Limited endpoints `GET /api/data (5 req/min)`, `GET /api/limited (2 req/min)` + home `/` returns live JSON `{"project":"93-rate-limited-api","status":"Live - Rate Limited API","tier":"10 - System Design Level","owner":"Raviteja"}`. This repo contains **RateLimit.java Annotation**, **RateLimitService (Bucket4j Token Bucket)**, **RateLimitInterceptor (429 Handling)**, **WebConfig (Interceptor Registry)**, **ApiController (2 endpoints with @RateLimit)**, **RateLimitServiceTest (JUnit 5 - 2 tests green)** - eliminating manual run only. One `git push` gives full Rate Limiting service live. Local uses `Bucket4j in-memory` fallback, on Production it auto switches to real Redis `Lettuce` via env.

This is Project 93 of Tier 10 - START - After Blue-Green Deploy (92), now real System Design base for URL Shortener Scale (94).

**Bug Fixed:** `Port 8080 already in use` - Old project 92 still running on 8080 - Fixed by changing `server.port=8095` in `application.properties` + Kill old javaw.exe from Task Manager - Same pattern as Tier 9 port conflict fix.

**Bug Fixed:** `JUnit red errors` - Missing `spring-boot-starter-test` - Fixed by adding `<dependency>spring-boot-starter-test</dependency>` in pom.xml + Maven Update Project - Green bar 2/2 Tests Passed.

**Bug Fixed:** `Wrong package com.ratelimiter.com.ratelimiter.service` - Double nested package - Fixed by deleting extra folder + creating correct package `com.ratelimiter.service` directly under `src/test/java` - Same as Tier 1 package fix.

---

# ✨ Features

- Rate Limit Ready status API with JSON response - `{"project":"93-rate-limited-api","status":"Live - Rate Limited API","tier":"10 - System Design Level"}`
- Fully production Rate Limiting service - 2 endpoints + home + 429 handling - In-memory on Render
- Token Bucket Algorithm - System Design core - `Bucket4j` + `Bandwidth.classic(requests, Refill.greedy(requests, Duration.ofMinutes(minutes)))` + `Bucket.builder().addLimit(limit).build()` - Interview ready
- Custom Annotation @RateLimit - `@Target(METHOD) @Retention(RUNTIME) int requests() default 5; int minutes() default 1;` - Clean AOP style
- RateLimitService - Central rate limit tracking - `ConcurrentHashMap<String, Bucket> buckets` + `computeIfAbsent(key, k -> Bucket.builder().addLimit(...).build())` + `tryConsume(1)` logic - Thread-safe
- Interceptor - `RateLimitInterceptor implements HandlerInterceptor` - Checks `X-Client-Id` header or `RemoteAddr` + `preHandle()` + If not allowed returns 429 + `response.getWriter().write("429 Too Many Requests")` + `return false` - Blocks abuse
- WebConfig - `WebMvcConfigurer` + `addInterceptors(registry.addInterceptor(interceptor))` - Registers interceptor globally
- ApiController - 2 rate limited endpoints - `@RateLimit(requests=5, minutes=1) GET /api/data` -> Returns `200 OK Success - You have 5 requests per minute` + `@RateLimit(requests=2, minutes=1) GET /api/limited` -> Returns `200 OK This API allows only 2 requests per minute` - Different limits per endpoint
- 429 Handling - 6th request `GET /api/data` -> Returns `429 Too Many Requests - Try after 1 minute` - Proper status code + message - Same as Tier 5 proper status codes
- Per Client-ID + Per IP - `X-Client-Id` header support + fallback to `request.getRemoteAddr()` - Real world distributed rate limiting
- Thread-Safe - `ConcurrentHashMap` ensures no race condition under high concurrency - Production ready
- JUnit 5 Tests - `RateLimitServiceTest` - `testAllow5Requests()` + `testBlock6thRequest()` - 2/2 green bar - 0 errors 0 failures - Tier 10 GitHub Goal JUnit + Mockito
- CONTRIBUTING.md - Added as per Tier 10 GitHub Goal - Open source ready
- Architecture Diagram - Token Bucket flow in README - Same as Tier 8 architecture diagram
- One-Command Deploy - Same `mvn spring-boot:run` pattern as Project 92
- Spring Boot banner v3.2.5 inside logs
- Tomcat initialized with port 8095 (http) inside - Tier 10 First Port 8095
- Started Application in 4.806 seconds (Local Eclipse Java 17) - Includes Interceptor + Service - FASTER than 92 (11.275s)
- Verified with Browser - `GET /api/data` 5 times 200 OK + 6th time 429 Too Many Requests - `GET /api/limited` 2 times 200 OK + 3rd time 429 - JUnit green bar
- Public Production Ready - Portfolio ready Rate Limiting project - Tier 10 START

---

# 🛠 Technologies Used

- Java 17.0.10
- Spring Boot 3.2.5 (Banner v3.2.5)
- Spring Web - REST API `@RestController` + `@RequestMapping("/api")` + `@GetMapping`
- Bucket4j 8.7.0 - Token Bucket - `Bandwidth.classic()` + `Refill.greedy()` + `Bucket.builder()`
- Custom Annotation - `@RateLimit` - `@Target(ElementType.METHOD)` + `@Retention(RetentionPolicy.RUNTIME)` - Design Pattern
- Interceptor Pattern - `HandlerInterceptor` + `preHandle()` + `WebMvcConfigurer` + `InterceptorRegistry`
- ConcurrentHashMap - `ConcurrentHashMap<String, Bucket>` - Thread-safe caching - System Design Caching
- JUnit 5 - `spring-boot-starter-test` - `@Test` + `Assertions.assertTrue` + `assertFalse` - 2 tests green
- Mockito - Ready in starter-test - For future controller mock tests - Tier 10 Tool
- Redis Ready - Architecture ready for `Lettuce` + `RedisTemplate` - Distributed rate limiting - Real companies use Redis cell
- H2 Not Needed - In-memory Bucket4j is enough for first version
- Docker Ready - Can add Dockerfile multi-stage same as 92
- Maven 3.9+
- Apache Tomcat 10.1.20 (Embedded) - TomcatWebServer port 8095
- Browser - Chrome - For `GET /api/data` 5x 200 OK + 6th 429 test
- Windows 11 - Eclipse IDE + Browser
- GitHub - Issues + Release v1.0.0 + CONTRIBUTING.md - Tier 10 GitHub Goal

---

# 📂 Project Structure - Rate Limited Repo

```text
93-rate-limited-api
│
├── .github
│   └── workflows
│       └── ci.yml (Optional - CI)
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── ratelimiter
│   │   │           ├── Application.java (Main + Tomcat 8095)
│   │   │           ├── annotation
│   │   │           │   └── RateLimit.java (@Target METHOD @Retention RUNTIME requests() minutes())
│   │   │           ├── controller
│   │   │           │   └── ApiController.java (GET /api/data 5/min + /api/limited 2/min with @RateLimit)
│   │   │           ├── interceptor
│   │   │           │   ├── RateLimitInterceptor.java (HandlerInterceptor preHandle 429 handling)
│   │   │           │   └── WebConfig.java (WebMvcConfigurer addInterceptors)
│   │   │           └── service
│   │   │               └── RateLimitService.java (ConcurrentHashMap<String, Bucket> + tryConsume logic)
│   │   │
│   │   └── resources
│   │       └── application.properties (server.port=8095)
│   │
│   └── test
│       └── java
│           └── com
│               └── ratelimiter
│                   └── service
│                       └── RateLimitServiceTest.java (JUnit 5 - testAllow5Requests + testBlock6thRequest - 2/2 green)
│
├── screenshots
│   ├── demo1.png (GET /api/data - Success 200 OK 5 requests per minute)
│   ├── demo2.png (GET /api/data 6th request - 429 Too Many Requests - Try after 1 minute)
│   └── demo3.png (JUnit Green Bar - 2/2 Tests Passed - 0 Errors 0 Failures - RateLimitServiceTest)
│
├── .gitignore
├── CONTRIBUTING.md (Tier 10 GitHub Goal)
├── mvnw
├── mvnw.cmd
├── pom.xml (No Lombok - Bucket4j + spring-boot-starter-test)
└── README.md
```

---


# 📸 Screenshots - 7 Demos - Rate Limiting Verified

### Demo 1 – Browser - GET / - Home Live JSON - Rate Limited API Tier 10 Start
[Demo1 Home](screenshots/demo1.png)

*GET https://nine3-rate-limited-api.onrender.com/ - Browser - 200 OK - Returns {"project":"93-rate-limited-api","status":"Live - Rate Limited API","tier":"10 - System Design Level","owner":"Raviteja","endpoints":["/api/data (5 req/min)","/api/limited (2 req/min)"]} - Proof of Home Live - Portfolio ready - Tier 10 START 93/102 - Fixed Whitelabel 404 with HomeController*

### Demo 2 – Browser - GET /api/data - Success 200 OK - 5 requests per minute
[Demo2 Data](screenshots/demo2.png)

*GET https://nine3-rate-limited-api.onrender.com/api/data - Browser - 200 OK - Returns "Success - You have 5 requests per minute" - First 5 requests allowed - Token Bucket has tokens - Proof of Rate Limiting Working - Live on Render*

### Demo 3 – Browser - GET /api/limited - 2 requests per minute - Different limit per endpoint
[Demo3 Limited](screenshots/demo3.png)

*GET https://nine3-rate-limited-api.onrender.com/api/limited - Browser - 200 OK - Returns "This API allows only 2 requests per minute" - Proof of Custom @RateLimit annotation - requests=2 vs requests=5 - Interview ready*

### Demo 4 – Browser - GET /api/data 6th request - 429 Too Many Requests - Blocking Works
[Demo4 429](screenshots/demo4.png)

*GET http://localhost:8095/api/data - 6th Refresh - 429 Too Many Requests - Returns "429 Too Many Requests - Try after 1 minute" - Proof of Blocking - Bucket empty - 5 allowed per minute - System Design core - Real API abuse protection*

### Demo 5 – Eclipse JUnit - Green Bar - 2/2 Tests Passed - RateLimitServiceTest
[Demo5 JUnit](screenshots/demo5.png)

*Eclipse JUnit - Runs: 2/2 - Errors: 0 - Failures: 0 - Green Bar - testAllow5Requests ✓ - testBlock6thRequest ✓ - Proof of Tier 10 Testing Goal - JUnit + Mockito*

### Demo 6 – Render Live - Deploy succeeded - 1m38s - Your service is live
[Demo6 Deploy](screenshots/demo6.png)

*Render Dashboard - Deploy succeeded | Live - Duration 1m38s - Source f33ed84 - Tomcat started on port 10000 - Started Application in 37.498s - Your service is live - https://nine3-rate-limited-api.onrender.com - Proof of Live Deployment*

### Demo 7 – Eclipse Console - Started Application in 4.806s - Tomcat 8095 - Bucket4j Ready
[Demo7 Console](screenshots/demo7.png)

*Eclipse Console - :: Spring Boot :: v3.2.5 - Tomcat initialized with port 8095 - WebApplicationContext initialization completed - Tomcat started on port 8095 - Started Application in 4.806 seconds - Proof of Local Run - No Lombok - Bucket4j Ready*



# ▶ How to Run - Rate Limited Repo

## 1⃣ Clone the Repository

```bash
git clone https://github.com/raviteja-dev950/93-rate-limited-api.git
cd 93-rate-limited-api
```

---

## 2⃣ Verify application.properties & Controllers

- Verify `src/main/resources/application.properties` - No Lombok - No Redis needed for first version

```properties
server.port=8095
```

## 3⃣ Run in Eclipse IDE (No Docker Needed) - Fresh Start

```text
File -> New -> Spring Starter Project
  Name: 93-rate-limited-api
  Group: com.ratelimiter
  Artifact: 93-rate-limited-api
  Package: com.ratelimiter
  Java: 17
  Dependencies: Spring Web
Finish

Replace src + pom.xml from this repo
Project -> Clean -> Clean all
Right Click Project -> Maven -> Update Project -> Force Update -> OK
Right Click Project -> Run As -> Spring Boot App
```

Expected Console:
```text
 :: Spring Boot ::                (v3.2.5)
 Tomcat initialized with port 8095 (http)
 Initializing Spring embedded WebApplicationContext
 Tomcat started on port 8095 (http) with context path ''
 Started Application in 4.806 seconds
```

## 4⃣ Test with Browser - 2 Endpoints

- GET http://localhost:8095/api/data -> 200 OK (5 times allowed, 6th 429)
- GET http://localhost:8095/api/limited -> 200 OK (2 times allowed, 3rd 429)
- Browser refresh 6 times fast -> 6th shows 429 Too Many Requests - Proof

## 5⃣ Test JUnit

```text
Right Click RateLimitServiceTest.java -> Run As -> JUnit Test
Expected: Runs 2/2 Errors 0 Failures 0 Green Bar
```

## 6⃣ Deploy to Render (Optional) - Live URL - TIER 10 START

```text
Runtime: Java 17
Build Command: ./mvnw clean package -DskipTests
Start Command: java -jar target/93-rate-limited-api-0.0.1-SNAPSHOT.jar
Port: 8095
```

---

# 🔄 Flow Diagram - How Rate Limiting Works

```text
    User Laptop (Eclipse + Browser)
        |
        +-- E:\Java-100-Projects\93-rate-limited-api
        |       +-- src -> Application.java (Main + Tomcat 8095)
        |       +-- annotation -> RateLimit.java (@RateLimit requests=5 minutes=1)
        |       +-- service -> RateLimitService.java (ConcurrentHashMap<String, Bucket> buckets + tryConsume)
        |       +-- interceptor -> RateLimitInterceptor.java (preHandle + X-Client-Id + RemoteAddr + 429)
        |       +-- controller -> ApiController.java (GET /api/data 5/min + /api/limited 2/min)
        |       +-- test -> RateLimitServiceTest.java (JUnit 5 - 2 tests green)
        |       +-- resources -> application.properties (server.port=8095)
        |       +-- screenshots (demo1-3)
        |
        v
    git push origin main
        |
        +---> GitHub Repository: raviteja-dev950/93-rate-limited-api
        |           |
        |           v
        |       Render Auto Deploy (Java)
        |           +-- Build mvn clean package
        |           +-- Start java -jar app.jar (PORT=8095)
        |           +-- Live: https://nine3-rate-limited-api.onrender.com
        |
        v
    Local Eclipse Run (No Redis needed - In-memory Bucket4j)
        |
        +-- Spring Boot App -> Tomcat 8095
        |     +-- Bucket4j
        |     |     +-- Bandwidth.classic(5, Refill.greedy(5, Duration.ofMinutes(1)))
        |     |     +-- Bucket.builder().addLimit(limit).build()
        |     |     +-- ConcurrentHashMap<String, Bucket> buckets
        |     |     +-- tryConsume(key) -> true if tokens >0 else false
        |     +-- Interceptor
        |     |     +-- WebConfig implements WebMvcConfigurer -> addInterceptors(registry.addInterceptor(interceptor))
        |     |     +-- RateLimitInterceptor implements HandlerInterceptor
        |     |           +-- preHandle(request, response, handler)
        |     |                 +-- handler instanceof HandlerMethod -> getMethodAnnotation(RateLimit.class)
        |     |                 +-- key = X-Client-Id header or RemoteAddr
        |     |                 +-- service.tryConsume(key, requests, minutes)
        |     |                       +-- If allowed -> return true -> Controller 200 OK
        |     |                       +-- If not allowed -> response.setStatus(429) + writer.write("429 Too Many Requests") + return false -> Block
        |     +-- Controllers
        |           +-- GET /api/data @RateLimit(requests=5, minutes=1) -> Success 5 per minute -> 6th 429
        |           +-- GET /api/limited @RateLimit(requests=2, minutes=1) -> 2 per minute -> 3rd 429
        |     +-- JUnit
        |           +-- RateLimitServiceTest
        |                 +-- testAllow5Requests() -> loop 5 times tryConsume -> assertTrue
        |                 +-- testBlock6thRequest() -> loop 5 times + 6th -> assertFalse -> Green Bar 2/2
        |
        v
    Future Redis Production (With Docker - Distributed Rate Limiting)
        |
        +-- Redis Architecture - Distributed
        |     +-- Redis Server - Port 6379 - docker run -d -p 6379:6379 redis
        |     +-- Spring Data Redis - Lettuce client - RedisTemplate<String, Bucket>
        |     +-- Replace ConcurrentHashMap with Redis Hash - buckets stored in Redis - All instances share same bucket
        |     +-- Real Commands: SET client:192.168.1.1:tokens 5 EX 60 + DECR client:192.168.1.1:tokens + If tokens <=0 return 429
        |     +-- Bucket4j Redis Extension - com.bucket4j:bucket4j-redis - JCache or Lettuce
        |
        v
    Browser / Portfolio
        |
        +-- localhost:8095/api/data -> 200 OK 5 times -> 429 6th - Rate Limit Verified
        +-- localhost:8095/api/limited -> 200 OK 2 times -> 429 3rd - Different limit per endpoint
        +-- JUnit Green Bar -> 2/2 Passed - Testing Verified - Tier 10 Goal
        +-- Live: https://nine3-rate-limited-api.onrender.com/api/data -> Same on Internet
              |
              v
    Portfolio: Live URL + GitHub + 3 Demo Screenshots + Flow -> Resume Ready - Tier 10 START 93/102 - Good Pay Package
```

---

# 🧪 API Testing Examples

```bash
curl http://localhost:8095/api/data
curl http://localhost:8095/api/data # 5 times -> 200 OK, 6th -> 429
curl http://localhost:8095/api/limited
curl -H "X-Client-Id: user123" http://localhost:8095/api/data
```

---

# 👨💻 Author

Ravi Teja

Java Full Stack Developer

102 Java Full Stack Projects Challenge

Project 93 / 102

Tier 10 – System Design Level – START – TIER 10 START 93/102

---

## ⭐ Support

If you found this project helpful, consider giving it a ⭐ Star on GitHub.

**Single Repo:** [93-rate-limited-api](https://github.com/raviteja-dev950/93-rate-limited-api)

**Live URL:** https://nine3-rate-limited-api.onrender.com/

**Tier 10:** 93 Rate Limited API + 94 URL Shortener Scale + 95 Chat WebSockets + 96 Video Streaming + 97 Search Elastic + 98 Recommendation + 99 Multi-tenant SaaS + 100 Audit Log + 101 SaaS Idea + 102 Capstone OSS = **TIER 10 FINAL 10 PROJECTS**
