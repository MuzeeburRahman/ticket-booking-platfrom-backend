package com.sapient.theatre.mgt.controller;


import com.sapient.theatre.mgt.entity.Movie;
import com.sapient.theatre.mgt.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theatres")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // POST /theatres/{id}/movies - Schedule a movie
    @PostMapping("/{id}/movies")
    public ResponseEntity<Movie> scheduleMovie(@PathVariable String id, @RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.scheduleMovie(id, movie));
    }
}
