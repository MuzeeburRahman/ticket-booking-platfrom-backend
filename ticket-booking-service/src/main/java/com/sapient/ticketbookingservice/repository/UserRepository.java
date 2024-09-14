package com.sapient.ticketbookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.ticketbookingservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
