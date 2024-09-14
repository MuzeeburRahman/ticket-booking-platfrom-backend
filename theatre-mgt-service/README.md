# Theatre Management Service

The **Theatre Management Service** is a microservice built using **Spring Boot**, designed to manage theatres, onboard theatre partners, and handle movie scheduling. The service is fault-tolerant using **Resilience4j**, follows the **OpenAPI specification** for API documentation, is **Dockerized** for containerization, and can be deployed on **Kubernetes**.

## Features

- **CRUD operations** for theatres (Create, Read, Update, Delete).
- **Fault Tolerance** using Resilience4j (Circuit Breaker, Retry).
- **OpenAPI Specification** for API documentation (Swagger).
- **Logging** with Log4j2.
- **Dockerized** for easy deployment.
- **Kubernetes Deployment** with `yaml` configuration.
- **Spring Data JPA** with H2 for testing.

## Tech Stack

- **Spring Boot** for RESTful APIs.
- **Spring Data JPA** for database access.
- **Resilience4j** for fault tolerance.
- **Log4j2** for logging.
- **H2 Database** for in-memory testing.
- **OpenAPI (Swagger)** for API documentation.
- **Docker** for containerization.
- **Kubernetes** for orchestration.

## Prerequisites

- **Java 17** or higher
- **Gradle** for building the project
- **Docker** for containerization
- **Kubernetes** (minikube, kubectl) for deployment

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/example/theatre-management-service.git
cd theatre-management-service
