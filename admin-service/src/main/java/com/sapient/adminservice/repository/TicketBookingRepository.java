package com.sapient.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.adminservice.model.TicketBooking;

@Repository
public interface TicketBookingRepository extends JpaRepository<TicketBooking, String> {

}
