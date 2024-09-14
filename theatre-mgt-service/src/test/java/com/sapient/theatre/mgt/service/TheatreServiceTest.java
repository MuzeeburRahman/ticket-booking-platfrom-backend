package com.sapient.theatre.mgt.service;

import com.sapient.theatre.mgt.entity.Theatre;
import com.sapient.theatre.mgt.repository.TheatreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class TheatreServiceTest {

    @InjectMocks
    private TheatreService theatreService;

    @Mock
    private TheatreRepository theatreRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateTheatre() {
        // Arrange
        Theatre theatre = new Theatre("1L", "Theatre Name", "Theatre Location", null);
        when(theatreRepository.save(theatre)).thenReturn(theatre);

        // Act
        Theatre result = theatreService.createTheatre(theatre);

        // Assert
        assertEquals(theatre, result);
        verify(theatreRepository).save(theatre);
    }

    @Test
    public void testGetAllTheatres() {
        // Arrange
        Theatre theatre1 = new Theatre("1L", "Theatre Name 1", "Location 1", null);
        Theatre theatre2 = new Theatre("2L", "Theatre Name 2", "Location 2", null);
        List<Theatre> theatres = Arrays.asList(theatre1, theatre2);
        when(theatreRepository.findAll()).thenReturn(theatres);

        // Act
        List<Theatre> result = theatreService.getAllTheatres();

        // Assert
        assertEquals(theatres, result);
        verify(theatreRepository).findAll();
    }

    @Test
    public void testGetTheatreById_Success() {
        // Arrange
        String id = "1L";
        Theatre theatre = new Theatre(id, "Theatre Name", "Theatre Location", null);
        when(theatreRepository.findById(id)).thenReturn(Optional.of(theatre));

        // Act
        Theatre result = theatreService.getTheatreById(id);

        // Assert
        assertEquals(theatre, result);
        verify(theatreRepository).findById(id);
    }

    @Test
    public void testGetTheatreById_NotFound() {
        // Arrange
        String id = "1L";
        when(theatreRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            theatreService.getTheatreById(id);
        });

        assertEquals("Theatre not found", exception.getMessage());
    }

    @Test
    public void testUpdateTheatre_Success() {
        // Arrange
        String id = "1L";
        Theatre existingTheatre = new Theatre(id, "Old Name", "Old Location", null);
        Theatre updatedTheatre = new Theatre(id, "Updated Name", "Updated Location", null);
        when(theatreRepository.findById(id)).thenReturn(Optional.of(existingTheatre));
        when(theatreRepository.save(existingTheatre)).thenReturn(updatedTheatre);

        // Act
        Theatre result = theatreService.updateTheatre(id, updatedTheatre);

        // Assert
        assertEquals(updatedTheatre, result);
        verify(theatreRepository).findById(id);
        verify(theatreRepository).save(existingTheatre);
    }

    @Test
    public void testUpdateTheatre_NotFound() {
        // Arrange
        String id = "1L";
        Theatre updatedTheatre = new Theatre(id, "Updated Name", "Updated Location", null);
        when(theatreRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            theatreService.updateTheatre(id, updatedTheatre);
        });

        assertEquals("Theatre not found", exception.getMessage());
    }
}
