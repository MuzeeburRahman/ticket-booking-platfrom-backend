
# Ticket Booking Platform Backend Services
Movie ticket booking platform is that caters to both B2B (theatre partners) and B2C (end customers) clients. Key goals we want to accomplish as part of the solution:
- Enable theatre partners to onboard their theatres over this platform and get access to a bigger customer base while going digital.
- Enable end customers to browse the platform to get access to movies across different cities, languages, and genres, as well as book tickets in advance with a seamless experience.

## Todo
- [x] Implement user-auth-service
- [x] Implement movie-catalog-service
- [x] Implement tickit-booking-service
- [x] Implement admin-service 
- [x] Implement theatre-mgt-service
- [x] Implement search-service
- [x] Add swagger documentation
- [x] Work on kafka implementation
- [x] Implement Docker
- [ ] Integrate Prometheus and Grafana
- [ ] Work on Kibana configuration
- [ ] Unit testing (Working on..)
- [ ] ELK-Centralized Logging/Metric/APM monitoring
- [ ] k8s(Working on ...)

## Tech Stack

**Server:** String Boot, MySql, JWT, Kafka,Prometheus,K8s,...

## Start/Run Application
**Prerequisites :**
- Start Zookeeper Server

       sh bin/zookeeper-server-start.sh config/zookeeper.properties

- Start Kafka Server / Broker

      sh bin/kafka-server-start.sh config/server.properties

## OpenAPI Endpoints
  - search-service:http://localhost:8086/swagger-ui/index.html
    - Browse theatres currently running the show (movie selected) in the town, including show timing by a chosen date.
        - http://localhost:8086/swagger-ui/index.html#/search-controller/searchTheatres
        - movieId:1, cityName:New York, showDate :2024-09-20
        - **Request:** http://localhost:8086/api/search/theatres?movieId=1&cityName=New%20York&showDate=2024-09-20
  - user-auth-service:http://localhost:8081/api/v1.0/moviebooking/swagger-ui/index.html
- movie-catalog-service:http://localhost:8082/api/v1.0/moviebooking/swagger-ui/index.html#
- theatre-mgt-service:http://localhost:8085/api/v1.0/moviebooking/swagger-ui/index.html#
- ticket-booking-service:http://localhost:8083/api/v1.0/moviebooking/swagger-ui/index.html#
- admin-service:http://localhost:8084/api/v1.0/moviebooking/swagger-ui/index.html#
