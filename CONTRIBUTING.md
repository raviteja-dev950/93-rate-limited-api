# Contributing to 93 - Rate Limited API

Thank you for considering contributing! This project is part of **102 Java Full Stack Projects - Tier 10 System Design Level**.

### 📍 Project Info
- **Tier:** 10 - System Design Level
- **Focus:** Scale + Polish
- **Skills:** Caching, Security, Testing, Design Patterns
- **Tools:** JUnit, Mockito, Redis, Bucket4j

### 🚀 How to Contribute

1.  **Fork the repo** - Click Fork on GitHub
2.  **Clone your fork**
    ```bash
    git clone https://github.com/YOUR_USERNAME/93-rate-limited-api.git
    ```
3.  **Create branch**
    ```bash
    git checkout -b feature/your-feature-name
    ```
4.  **Make changes**
    - Follow Java 17 best practices
    - No Lombok - use plain Java
    - Add JUnit tests for new features
    - Handle 429 Too Many Requests properly

5.  **Test**
    ```bash
    mvn test
    ```
    - Must show green bar - 2/2 tests passing

6.  **Commit**
    ```bash
    git commit -m "Add: your feature description"
    ```

7.  **Push and PR**
    ```bash
    git push origin feature/your-feature-name
    ```
    - Go to GitHub and click "Create Pull Request"

### 📝 Code Standards (As per Roadmap for Good Pay)

- **Java Version:** 17
- **Spring Boot:** 3.2.5
- **No Lombok** - Write explicit constructors, getters
- **Rate Limiting:** Use Bucket4j Token Bucket algorithm
- **Status Codes:** 200 OK, 429 Too Many Requests (must handle)
- **Tests:** JUnit 5 + Mockito

### 🐛 Reporting Issues

- Use GitHub Issues tab
- **Bug Report:** Describe steps, expected vs actual
- **Feature Request:** Explain System Design use case
- Example: "Add Sliding Window algorithm"

### 📦 Release Process

- `v1.0.0` - In-memory rate limiting with Bucket4j (Current)
- `v1.1.0` - Redis distributed rate limiting (Planned)
- `v1.2.0` - Sliding window + Fixed window support (Planned)

### 📧 Contact

- GitHub: raviteja-dev950
- LinkedIn: vemulaleelavenkataraviteja

Happy Coding! Please follow roadmap exactly for good pay.
