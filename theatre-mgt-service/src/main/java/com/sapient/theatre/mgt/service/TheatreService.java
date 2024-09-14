package com.sapient.theatre.mgt.service;

import com.sapient.theatre.mgt.entity.Theatre;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import com.sapient.theatre.mgt.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    public Theatre createTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    @CircuitBreaker(name = "theatreService", fallbackMethod = "fallbackGetTheatreById")
    @Retry(name = "theatreService")
    public Theatre getTheatreById(String id) {
        return theatreRepository.findById(id).orElseThrow(() -> new RuntimeException("Theatre not found"));
    }
    public Theatre updateTheatre(String id, Theatre updatedTheatre) {
        Theatre existingTheatre = theatreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Theatre not found"));

        existingTheatre.setName(updatedTheatre.getName());
        existingTheatre.setLocation(updatedTheatre.getLocation());


        return theatreRepository.save(existingTheatre);
    }

}
