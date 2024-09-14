package com.sapient.adminservice.services;

import com.sapient.adminservice.exceptions.InvalidTokenException;
import com.sapient.adminservice.exceptions.ResourceNotFoundException;
import com.sapient.adminservice.feign.AuthClient;
import com.sapient.adminservice.model.Movie;
import com.sapient.adminservice.repository.MovieRepository;
import com.sapient.adminservice.service.AdminService;
import com.sapient.adminservice.dto.ValidationDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class AdminServiceTest {

    @InjectMocks
    private AdminService adminService;

    @Mock
    private AuthClient authClient;

    @Mock
    private MovieRepository movieRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDeleteMovie_success() {
        // Mock token validation to simulate an admin user
        String token = "valid-admin-token";
        ValidationDto validationDto = new ValidationDto();
        validationDto.setStatus(true);
        validationDto.setRole("ADMIN");
        
        when(authClient.validateAuthToken(token)).thenReturn(validationDto);

        // Mock the movie retrieval
        String movieId = "M123";
        Movie movie = new Movie();
        movie.setId(movieId);
        
        when(movieRepository.findById(movieId)).thenReturn(Optional.of(movie));

        // Perform the delete action
        adminService.deleteMovie(token, movieId);

        // Verify that the movie was deleted
        verify(movieRepository, times(1)).delete(movie);
    }

    @Test
    public void testDeleteMovie_nonAdminThrowsException() {
        // Mock token validation to simulate a non-admin user
        String token = "non-admin-token";
        ValidationDto validationDto = new ValidationDto();
        validationDto.setStatus(true);
        validationDto.setRole("USER"); // Non-admin role
        
        when(authClient.validateAuthToken(token)).thenReturn(validationDto);

        // Assert that an InvalidTokenException is thrown
        assertThrows(InvalidTokenException.class, () -> {
            adminService.deleteMovie(token, "M123");
        });
    }

    @Test
    public void testDeleteMovie_movieNotFoundThrowsException() {
        // Mock token validation to simulate an admin user
        String token = "valid-admin-token";
        ValidationDto validationDto = new ValidationDto();
        validationDto.setStatus(true);
        validationDto.setRole("ADMIN");
        
        when(authClient.validateAuthToken(token)).thenReturn(validationDto);

        // Mock movie not found scenario
        String movieId = "M123";
        
        when(movieRepository.findById(movieId)).thenReturn(Optional.empty());

        // Assert that a ResourceNotFoundException is thrown
        assertThrows(ResourceNotFoundException.class, () -> {
            adminService.deleteMovie(token, movieId);
        });
    }
}
