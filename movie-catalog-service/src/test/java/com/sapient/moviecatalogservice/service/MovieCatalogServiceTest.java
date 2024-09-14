package com.sapient.moviecatalogservice.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.sapient.moviecatalogservice.dto.AllMovieResponse;
import com.sapient.moviecatalogservice.dto.MovieDto;
import com.sapient.moviecatalogservice.dto.ShowingDto;
import com.sapient.moviecatalogservice.exceptions.ResourceNotFoundException;
import com.sapient.moviecatalogservice.model.Movie;
import com.sapient.moviecatalogservice.model.Showing;
import com.sapient.moviecatalogservice.model.Theater;
import com.sapient.moviecatalogservice.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class MovieCatalogServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieCatalogService movieCatalogService;

    private Movie movie;
    private Showing showing;
    private Theater theater;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        theater = Theater.builder()
                .id("T1")
                .name("Cinema Hall 1")
                .location("New York")
                .build();

        showing = Showing.builder()
                .id("S1")
                .theater(theater)
                .showTime("2024-09-15 10:00:00")
                .totalSeats(100)
                .bookedSeats(50)
                .build();

        movie = Movie.builder()
                .id("M1")
                .title("Test Movie")
                .description("A test movie description")
                .releaseDate(LocalDate.parse("2024-09-01"))
                .runtime(120)
                .genre("Drama")
                .language("English")
                .country("USA")
                .director("Test Director")
                .cast("Actor 1, Actor 2")
                .rating(String.valueOf(8.5))
                .posterUrl("https://example.com/poster.jpg")
                .trailerUrl("https://example.com/trailer.mp4")
                .shows(List.of(showing))
                .build();
    }

    @Test
    void testGetAllMovies() {
        // Arrange
        when(movieRepository.findAll()).thenReturn(Arrays.asList(movie));

        // Act
        AllMovieResponse allMovieResponse = movieCatalogService.getAllMovies();

        // Assert
        assertNotNull(allMovieResponse);
        assertEquals(1, allMovieResponse.getMovies().size());
        assertEquals("Test Movie", allMovieResponse.getMovies().get(0).getTitle());
        verify(movieRepository, times(1)).findAll();
    }

    @Test
    void testGetMovieById_Success() {
        // Arrange
        when(movieRepository.findById("M1")).thenReturn(Optional.of(movie));

        // Act
        MovieDto movieDto = movieCatalogService.getMovieById("M1");

        // Assert
        assertNotNull(movieDto);
        assertEquals("Test Movie", movieDto.getTitle());
        assertEquals(1, movieDto.getShows().size());
        assertEquals("Cinema Hall 1", movieDto.getShows().get(0).getName());
        verify(movieRepository, times(1)).findById("M1");
    }

    @Test
    void testGetMovieById_NotFound() {
        // Arrange
        when(movieRepository.findById("M1")).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> movieCatalogService.getMovieById("M1"));
        verify(movieRepository, times(1)).findById("M1");
    }
}
