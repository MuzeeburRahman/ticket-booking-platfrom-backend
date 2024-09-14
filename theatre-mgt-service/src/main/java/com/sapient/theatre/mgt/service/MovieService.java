package com.sapient.theatre.mgt.service;


import com.sapient.theatre.mgt.entity.Movie;
import com.sapient.theatre.mgt.entity.Theatre;
import com.sapient.theatre.mgt.repository.MovieRepository;
import com.sapient.theatre.mgt.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    // Schedule a movie for a specific theatre
    public Movie scheduleMovie(String theatreId, Movie movie) {
        Theatre theatre = theatreRepository.findById(theatreId)
                .orElseThrow(() -> new RuntimeException("Theatre not found"));

        // Additional logic can be added here to check for schedule conflicts, etc.
        
        return movieRepository.save(movie);  // Save the movie in the database
    }
}
