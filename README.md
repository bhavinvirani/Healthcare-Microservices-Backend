<div align="center">
  <br>
  <img alt="Healthcare Backend" src="https://github.com/user-attachments/assets/d5f4f99b-0027-4f00-afb8-b10cee2acd31" width="120px">
</div>


# Healthcare Microservices Backend

A cloud-ready, containerized **Java Spring Boot** backend for a healthcare management system, designed using a **microservices architecture**. This backend enables asynchronous communication, high availability, and efficient scalability across multiple services.

---

### 🚀 Features

- **Patient Management Service**: Handles patient registration, updates, and information retrieval.
- **Appointment Service**: Manages appointment booking, status updates, and scheduling.
- **Notification Service**: Sends alerts via message queue integration.
- **Asynchronous Communication**: Powered by **Kafka** and **gRPC** for robust inter-service messaging.
- **API Gateway**: Unified entry point for all client requests.
- **Service Discovery**: Dynamically locates services using **Spring Cloud Netflix Eureka**.
- **Containerization**: Dockerized services orchestrated via Docker Compose.
- **Cloud Deployment**: Built to deploy on **AWS ECS**, using RDS for persistence and Kafka for stream processing.

---

### ⚙️ Tech Stack

#### 📌 Core Technologies:
- **Java 17**, **Spring Boot**
- **Spring Cloud Gateway**, **Eureka Discovery**
- **Kafka**, **gRPC**, **Feign Client**
- **PostgreSQL**
- **Docker**, **Docker Compose**
- **AWS (ECS, RDS, EC2)**

---

### 🧩 Microservices Architecture

```plaintext
             +-------------+         +----------------+
             |  API Gateway| <-----> |  Client (React)|
             +------+------+
                    |
     +--------------+--------------+
     |              |              |
+----v---+      +---v----+     +---v----+
| Patient|      |Appointment|  |Notification|
|Service |      |  Service |  |  Service   |
+----+---+      +----+----+     +----+-----+
     |               |               |
     +---------------+---------------+
                     |
                 Kafka Bus
```


Each microservice has its own **database schema**, allowing independent scaling and failure isolation.

---

### 🧪 How to Run (Dev Setup)

#### ✅ Prerequisites

- Docker & Docker Compose
- JDK 17+
- Maven
- Kafka & Zookeeper (Dockerized)

#### 🏁 Steps

1. **Clone the repo**
   ```bash
   git clone https://github.com/bhavinvirani/Healthcare-Microservices-Backend.git
   cd Healthcare-Microservices-Backend
   ```

2. **Start Kafka & Zookeeper (via Docker)**
   ```bash
   docker-compose -f kafka-docker-compose.yml up -d
   ```

3. **Start Microservices**
   Each service (patient, appointment, notification) can be run independently using:
   ```bash
   cd patient-service
   mvn spring-boot:run
   ```

4. **Access Eureka Dashboard**
   - [http://localhost:8761](http://localhost:8761)

5. **Use Postman or frontend client to test endpoints via the Gateway**
   - API Gateway: `http://localhost:8080`

---

### 📦 Docker Deployment (All Services)

```bash
docker-compose -f docker-compose.yml up --build
```

---

### 🌩️ Cloud Deployment (AWS ECS)

- Docker images are pushed to **ECR**
- Services deployed via **ECS + Fargate**
- **RDS PostgreSQL** for production-grade persistence
- Secure configuration through **Secrets Manager**

---

### 📈 Future Enhancements

- JWT-based security and authentication gateway
- Centralized logging with ELK stack or CloudWatch
- Monitoring with Prometheus & Grafana
- CI/CD automation using GitHub Actions or AWS CodePipeline

---

### 🤝 Contributing

Contributions, issues, and feature requests are welcome. Please fork the repo and submit a pull request.

