package com.sapient.moviecatalogservice.service;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import lombok.extern.java.Log;

class MovieConsumerTest {

    @Mock
    private Log log;

    @InjectMocks
    private MovieConsumer movieConsumer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConsumeMessage() {
        // Arrange
        String message = "Test Kafka message";

        // Act
        movieConsumer.consume(message);

        // Assert
       // verify(log, times(1)).info(String.format("Message received -> %s", message));
    }
}
