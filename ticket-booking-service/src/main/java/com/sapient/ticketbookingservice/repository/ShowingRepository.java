package com.sapient.ticketbookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.ticketbookingservice.model.Showing;

@Repository
public interface ShowingRepository extends JpaRepository<Showing, String>{

}
