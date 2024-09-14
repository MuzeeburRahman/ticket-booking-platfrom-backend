
# Ticket Booking Platform Backend Services
Movie ticket booking platform is that caters to both B2B (theatre partners) and B2C (end customers) clients. Key goals we want to accomplish as part of the solution:
- Enable theatre partners to onboard their theatres over this platform and get access to a bigger customer base while going digital.
- Enable end customers to browse the platform to get access to movies across different cities, languages, and genres, as well as book tickets in advance with a seamless experience.
# Requirements
## Functional (Good to have - Code Implementation)
### Anyone of the following read scenarios: (Only Service Implementation needed/ No UI required)

- Browse theatres currently running the show (movie selected) in the town, including show timing by a chosen date.

- Booking platform offers in selected cities and theatres
    - 50% discount on the third ticket
    - Tickets booked for the afternoon show get a 20% discount
  
### Anyone of the following write scenarios: Good to have - Code Implementation (write scenario):
- Book movie tickets by selecting a theatre, timing, and preferred seats for the day
- Theatres can create, update, and delete shows for the day.
- Bulk booking and cancellation
- Theatres can allocate seat inventory and update them for the show
## Non-functional requirements-(Mandatory -Design/Arch solution & Optional Implementation):
      •	Describe transactional scenarios and design decisions to address the same.
      •	Integrate with theatres having existing IT system and new theatres and localization(movies)
      •	How will you scale to multiple cities, countries and guarantee platform availability of 99.99%?
      •	Integration with payment gateways
      •	How do you monetize platform?
      •	How to protect against OWASP top 10 threats.
      •	Any Compliance


## Todo
- [x] Implement user-auth-service
- [x] Implement movie-catalog-service
- [x] Implement tickit-booking-service
- [x] Implement admin-service 
- [ ] Add spring-cloud
- [x] Add swagger documentation
- [x] Work on kafka implementation
- [ ] Integrate Prometheus and Grafana
- [ ] Work on Kibana configuration
- [ ] Unit testing 

## Tech Stack

**Server:** String Boot, MySql, JWT, Kafka

