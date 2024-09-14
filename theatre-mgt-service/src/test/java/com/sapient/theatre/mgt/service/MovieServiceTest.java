package com.sapient.theatre.mgt.service;

import com.sapient.theatre.mgt.entity.Movie;
import com.sapient.theatre.mgt.entity.Theatre;
import com.sapient.theatre.mgt.repository.MovieRepository;
import com.sapient.theatre.mgt.repository.TheatreRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class MovieServiceTest {

    @InjectMocks
    private MovieService movieService;

    @Mock
    private MovieRepository movieRepository;

    @Mock
    private TheatreRepository theatreRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testScheduleMovie_Success() {
        // Arrange
        String theatreId = "1L";
        Movie movie = new Movie();
        movie.setId("movie1");
        movie.setTitle("Inception");
        // Set other movie fields as necessary

        Theatre theatre = new Theatre();
        theatre.setId(theatreId);
        theatre.setName("Grand Theatre");
        // Set other theatre fields as necessary

        when(theatreRepository.findById(theatreId)).thenReturn(Optional.of(theatre));
        when(movieRepository.save(movie)).thenReturn(movie);

        // Act
        Movie result = movieService.scheduleMovie(theatreId, movie);

        // Assert
        assertEquals(movie, result);
        verify(theatreRepository).findById(theatreId);
        verify(movieRepository).save(movie);
    }

    @Test
    public void testScheduleMovie_TheatreNotFound() {
        // Arrange
        String theatreId = "1L";
        Movie movie = new Movie();
        movie.setId("movie1");
        movie.setTitle("Inception");
        // Set other movie fields as necessary

        when(theatreRepository.findById(theatreId)).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            movieService.scheduleMovie(theatreId, movie);
        });

        assertEquals("Theatre not found", exception.getMessage());
    }
}
