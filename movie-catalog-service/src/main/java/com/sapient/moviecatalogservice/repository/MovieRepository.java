package com.sapient.moviecatalogservice.repository;

import com.sapient.moviecatalogservice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, String>{

}
