package com.sapient.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.adminservice.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {

}
