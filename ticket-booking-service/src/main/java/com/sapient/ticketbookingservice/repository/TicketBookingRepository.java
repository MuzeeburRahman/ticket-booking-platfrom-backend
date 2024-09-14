package com.sapient.ticketbookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.ticketbookingservice.model.TicketBooking;

@Repository
public interface TicketBookingRepository extends JpaRepository<TicketBooking, String>{
	
}
