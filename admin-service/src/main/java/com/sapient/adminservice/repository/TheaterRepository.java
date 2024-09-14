package com.sapient.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapient.adminservice.model.Theater;

public interface TheaterRepository extends JpaRepository<Theater, String> {

}
