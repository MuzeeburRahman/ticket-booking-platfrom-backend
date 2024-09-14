package com.sapient.adminservice.services;

import com.sapient.adminservice.service.MovieProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.kafka.core.KafkaTemplate;
import static org.mockito.Mockito.*;

class MovieProducerTest {

    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    @InjectMocks
    private MovieProducer movieProducer;

    private String topicName = "test-topic";

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        // Set the topicName field manually since @Value isn't processed in tests
        movieProducer = new MovieProducer(topicName, kafkaTemplate);
    }

    @Test
    void testSendMessage() {
        // Given
        String message = "New movie created";

        // When
        movieProducer.sendMessage(message);

        // Then
        // Verify that the KafkaTemplate's send method is called with the correct topic name and message
        verify(kafkaTemplate, times(1)).send(topicName, message);
    }
}
