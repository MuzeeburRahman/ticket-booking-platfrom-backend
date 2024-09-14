package com.moviebooking.search.service.repository;

import com.moviebooking.search.service.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {

    List<Theatre> findByCityNameAndScreensShowsMovieIdAndScreensShowsShowDate(String cityName, Long movieId, Date showDate);
}
