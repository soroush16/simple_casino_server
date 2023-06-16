package com.assignment.clients;

import com.assignment.dto.PlayerMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.messaging.simp.stomp.StompSession;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class ClientTest {
    @Mock
    private StompSession stompSession;

    //private ClientSessionHandler sessionHandler;

    /*@BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        sessionHandler = new ClientSessionHandler();
    }*/

    /*@Test
    public void testCreatePlayerMessage() throws InterruptedException {
        // Given
        InputStream inputStream = new ByteArrayInputStream("10\n5".getBytes());
        System.setIn(inputStream);
        when(stompSession.send(anyString(), any())).thenReturn(null);

        // When
        Client.createPlayerMessage(stompSession);

        // Then
        verify(stompSession, times(1)).send(eq("/app/process-message"), any(PlayerMessage.class));

    }*/


}