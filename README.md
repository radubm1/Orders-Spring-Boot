# Orders-Spring-Boot

A simple Spring Boot application for managing customer orders.  
This project demonstrates how to build RESTful APIs with Spring Boot, validate request payloads, and return structured JSON responses.

---

## 🚀 Features
- REST API for creating and testing orders
- Input validation using `javax.validation` annotations
- Global exception handling for clean error responses
- JSON serialization with pretty-print enabled (`spring.jackson.serialization.indent_output=true`)
- Example endpoints for both **POST** and **GET**

---

## 📂 Project Structure
- `src/main/java` → Application source code
- `src/main/resources` → Configuration files (`application.properties`)
- `pom.xml` → Maven build configuration

---

## ⚙️ Requirements
- Java 17+ (or compatible JDK)
- Maven 3.8+
- Spring Boot 3.x

---

## ▶️ Running the Application
1. Clone the repository:
   ```bash
   git clone https://github.com/radubm1/Orders-Spring-Boot.git
   cd Orders-Spring-Boot
   ```

2. Build and run with Maven:
   ```bash
   mvn spring-boot:run
   ```

3. The application will start on:
   ```
   http://localhost:8080
   ```

---

## 🌐 API Endpoints

### Health Check
```http
GET /orders/test
```
**Response:**
```json
"Orders endpoint is alive!"
```

### Create Order
```http
POST /orders
Content-Type: application/json
```

**Request Body Example:**
```json
{
  "orderId": "123",
  "customer": {
    "name": "Alice",
    "email": "alice@email.com"
  },
  "items": [
    { "productId": "P001", "quantity": 2, "price": 19.99 },
    { "productId": "P002", "quantity": 1, "price": 49.99 }
  ]
}
```

**Successful Response:**
```json
"Order accepted: 123"
```

**Validation Errors (400 Bad Request):**
```json
{
  "timestamp": "2025-12-04T12:20:33.886+00:00",
  "status": 400,
  "error": "Bad Request",
  "path": "/orders"
}
```

---

## 🧪 Testing with curl

### GET
```bash
curl -X GET http://localhost:8080/orders/test
```

### POST (PowerShell)
```powershell
curl -X POST http://localhost:8080/orders `
  -H "Content-Type: application/json" `
  -d '{"orderId":"123","customer":{"name":"Alice","email":"alice@email.com"},"items":[{"productId":"P001","quantity":2,"price":19.99},{"productId":"P002","quantity":1,"price":49.99}]}'
```

### POST (CMD)
```cmd
curl -X POST http://localhost:8080/orders -H "Content-Type: application/json" -d "{\"orderId\":\"123\",\"customer\":{\"name\":\"Alice\",\"email\":\"alice@email.com\"},\"items\":[{\"productId\":\"P001\",\"quantity\":2,\"price\":19.99},{\"productId\":\"P002\",\"quantity\":1,\"price\":49.99}]}"
```

---

## 📖 Notes
- Validation rules may reject orders with totals below a threshold (e.g., `< 20`).
- Customize `application.properties` for logging and serialization options.
- Extend the project with additional endpoints (e.g., `GET /orders/{id}`) to fetch stored orders.

---

## 📜 License
This project is licensed under the MIT License.
