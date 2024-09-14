package com.sapient.theatre.mgt.controller;

import com.sapient.theatre.mgt.entity.Theatre;
import com.sapient.theatre.mgt.service.TheatreService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class TheatreControllerTest {

    @Mock
    private TheatreService theatreService;

    @InjectMocks
    private TheatreController theatreController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(theatreController).build();
    }

    @Test
    void testUpdateTheatre() throws Exception {
        // Arrange
        Theatre updatedTheatre = new Theatre("1", "Updated Name", "Updated City", new ArrayList<>());
        when(theatreService.updateTheatre(anyString(), any(Theatre.class))).thenReturn(updatedTheatre);

        // Act & Assert
        mockMvc.perform(put("/theatres/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"name\": \"Updated Name\", \"city\": \"Updated City\", \"address\": \"Updated Address\", \"totalSeats\": 150 }"))
                .andExpect(status().isOk());

        verify(theatreService, times(1)).updateTheatre(anyString(), any(Theatre.class));
    }
}
