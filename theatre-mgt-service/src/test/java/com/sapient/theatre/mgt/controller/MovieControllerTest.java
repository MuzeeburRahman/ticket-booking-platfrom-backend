package com.sapient.theatre.mgt.controller;

import com.sapient.theatre.mgt.entity.Movie;
import com.sapient.theatre.mgt.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MovieControllerTest {

    @Mock
    private MovieService movieService;

    @InjectMocks
    private MovieController movieController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(movieController).build();
    }

    @Test
    void testScheduleMovie() throws Exception {
        // Arrange
        Movie movie = new Movie("1", "Movie Title", "Action", "English", "2024-09-15T19:00:00");
        when(movieService.scheduleMovie(anyString(), any(Movie.class))).thenReturn(movie);

        // Act & Assert
        mockMvc.perform(post("/theatres/1/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"title\": \"Movie Title\", \"genre\": \"Action\", \"language\": \"English\", \"showTime\": \"2024-09-15T19:00:00\" }"))
                .andExpect(status().isOk());

        verify(movieService, times(1)).scheduleMovie(anyString(), any(Movie.class));
    }
}
