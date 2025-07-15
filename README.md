# Spring Boot 3 with Hibernate 6 and Java 21

A modern REST API demonstration project showcasing Spring Boot 3 integration with Hibernate 6 and Java 21 features, using PostgreSQL database and Docker containerization.

📘 Blog Post: [Spring boot 3 with Hibernate 6 and Java 21](https://jarmx.blogspot.com/2022/11/spring-boot-3-with-hibernate-6.html)


## 🚀 Features

- **Spring Boot 3.2.0** - Latest Spring Boot framework with Jakarta EE 9 support
- **Hibernate 6.4.1** - Advanced ORM with Jakarta Persistence 3.1 compatibility
- **Java 21** - Modern Java features including text blocks and enhanced performance
- **PostgreSQL** - Robust relational database integration
- **Docker Compose** - Simplified environment setup
- **RESTful API** - Clean REST endpoints with proper HTTP status codes
- **Unit Testing** - Comprehensive test coverage with MockMvc
- **Custom Repository** - Advanced database operations with stored procedures
- **Lombok** - Reduced boilerplate code

## 📋 Prerequisites

- Java 21 or later
- Maven 3.6+
- Docker & Docker Compose
- Git

## 🏗️ Project Structure

```
spring3-hibernate6/
├── src/
│   ├── main/
│   │   ├── java/com/henry/
│   │   │   ├── controller/     # REST controllers
│   │   │   ├── model/         # Entity models
│   │   │   ├── repository/    # Data access layer
│   │   │   ├── service/       # Business logic
│   │   │   └── Application.java
│   │   └── resources/
│   │       └── application.yml
│   └── test/
│       └── java/com/henry/
├── docker-compose-postgresql.yml
├── pom.xml
└── README.md
```

## 🛠️ Technology Stack

| Technology | Version | Purpose |
|------------|---------|---------|
| Java | 21 | Programming language |
| Spring Boot | 3.2.0 | Application framework |
| Hibernate | 6.4.1 | ORM framework |
| PostgreSQL | 14.1 | Database |
| Maven | 3.6+ | Build tool |
| Docker | Latest | Containerization |
| Lombok | Latest | Code generation |
| JUnit 5 | Latest | Testing framework |

## 🚀 Quick Start

### 1. Clone the Repository
```bash
git clone https://github.com/HenryXiloj/spring-boot3-hibernate6.git
cd spring3-hibernate6
```

### 2. Start the Database
```bash
docker-compose -f docker-compose-postgresql.yml up -d
```

### 3. Run the Application
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:9000`

## 🔧 Configuration

### Database Configuration (`application.yml`)
```yaml
server:
  port: 9000
  servlet:
    context-path: /

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/postgre_test
    username: postgre_test
    password: postgre_test
    driver-class-name: org.postgresql.Driver
  jpa:
    show-sql: true
    hibernate:
      ddl-auto: create-drop
```

### Docker Compose Configuration
The project includes a PostgreSQL container setup:
```yaml
version: '3'
services:
  postgres:
    image: postgres:14.1
    container_name: postgre_test
    environment:
      POSTGRES_USER: postgre_test
      POSTGRES_PASSWORD: postgre_test
      POSTGRES_DB: postgre_test
    ports:
      - "5432:5432"
```

## 📚 API Endpoints

### User Management
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/users/hello` | Simple hello world endpoint |
| GET | `/api/users` | Get all users |
| POST | `/api/users` | Create a new user |
| GET | `/api/users/sum/{a}/{b}` | Calculate sum using stored procedure |

### Example API Requests

#### Create a User
```bash
curl -X POST http://localhost:9000/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "John",
    "lastName": "Doe"
  }'
```

#### Get All Users
```bash
curl http://localhost:9000/api/users
```

#### Calculate Sum
```bash
curl http://localhost:9000/api/users/sum/5/10
```

## 🧪 Testing

### Run All Tests
```bash
mvn test
```

### Run Specific Test Class
```bash
mvn test -Dtest=UserControllerTests
```

### Test Coverage
The project includes comprehensive unit tests covering:
- Controller layer testing with MockMvc
- Service layer mocking
- JSON serialization/deserialization
- HTTP status code validation

## 💡 Key Features Demonstrated

### 1. Jakarta EE 9 Migration
- Uses `jakarta.*` packages instead of `javax.*`
- Compatible with Jakarta Persistence 3.1

### 2. Modern Java Features
- **Text Blocks** (Java 13+): Used in the hello endpoint
- **Enhanced Performance**: Java 21 optimizations
- **Pattern Matching**: Ready for future enhancements

### 3. Advanced Hibernate Features
- Custom repository implementations
- Stored procedure execution
- Entity lifecycle management
- Connection pooling optimization

### 4. Spring Boot 3 Enhancements
- Improved auto-configuration
- Better observability support
- Enhanced security features
- GraalVM native image support (ready)

## 🔍 Database Schema

### Users Table
```sql
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255)
);
```

### Sample Stored Procedure
```sql
CREATE OR REPLACE FUNCTION get_sum(a INTEGER, b INTEGER)
RETURNS INTEGER AS $$
BEGIN
    RETURN a + b;
END;
$$ LANGUAGE plpgsql;
```

## 📦 Build and Deployment

### Build JAR
```bash
mvn clean package
```

### Run JAR
```bash
java -jar target/spring3-hibernate6-0.0.1-SNAPSHOT.jar
```

### Docker Build (Optional)
```bash
docker build -t spring3-hibernate6 .
docker run -p 9000:9000 spring3-hibernate6
```

## 🔧 Development Setup

### IDE Configuration
1. **IntelliJ IDEA**: Import as Maven project
2. **Eclipse**: Use Spring Tools Suite
3. **VS Code**: Install Java Extension Pack

### Environment Variables
```bash
export SPRING_PROFILES_ACTIVE=dev
export DB_HOST=localhost
export DB_PORT=5432
export DB_NAME=postgre_test
```

## 📋 Troubleshooting

### Common Issues

1. **Database Connection Error**
   - Ensure PostgreSQL container is running
   - Check database credentials in `application.yml`

2. **Port Already in Use**
   - Change server port in `application.yml`
   - Kill existing processes: `sudo lsof -ti:9000 | xargs kill -9`

3. **Maven Build Issues**
   - Ensure Java 21 is properly configured
   - Clear Maven cache: `mvn clean install -U`

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/new-feature`
3. Commit changes: `git commit -m 'Add new feature'`
4. Push to branch: `git push origin feature/new-feature`
5. Submit a pull request

## 📚 Additional Resources

- [Spring Boot 3 Documentation](https://spring.io/projects/spring-boot)
- [Hibernate 6 Documentation](https://hibernate.org/orm/documentation/6.0/)
- [Jakarta EE 9 Specification](https://jakarta.ee/specifications/persistence/)
- [Java 21 Documentation](https://docs.oracle.com/en/java/javase/21/)
- [Detailed Blog Post](https://jarmx.blogspot.com/2022/11/spring-boot-3-with-hibernate-6.html)
