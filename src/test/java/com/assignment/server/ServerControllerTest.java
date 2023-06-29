package com.assignment.server;

import com.assignment.dto.PlayerMessage;
import com.assignment.dto.Result;
import com.assignment.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServerControllerTest {
    @Mock
    private GameService gameService;
    private ServerController serverController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        serverController = new ServerController(gameService);
    }

    @Test
    public void testProcessMessage() throws Exception {
        // Given
        PlayerMessage playerMessage = new PlayerMessage();
        Result expectedResult = new Result();

        when(gameService.playGameLogic(playerMessage)).thenReturn(expectedResult);

        // When
        Result actualResult = serverController.processMessage(playerMessage);

        // Then
        assertEquals(expectedResult, actualResult);
        verify(gameService, times(1)).playGameLogic(playerMessage);
    }

    @Test
    public void testProcessMessageWhenBetIsZero() throws Exception {
        // Given
        PlayerMessage playerMessage = new PlayerMessage(0, 10);
        // When
        Result result = serverController.processMessage(playerMessage);

        // Then
        assertEquals(result, null);

    }

    @Test
    public void testProcessMessageWhenBetIsMinus() throws Exception {
        // Given
        PlayerMessage playerMessage = new PlayerMessage(-100, 10);
        // When
        Result result = serverController.processMessage(playerMessage);
        // Then
        assertEquals(result, null);

    }

    @Test
    public void testProcessMessageWhenNumberIsOutOfRange() throws Exception {
        // Given
        PlayerMessage playerMessage = new PlayerMessage(10000, 200);
        // When
        Result result = serverController.processMessage(playerMessage);
        // Then
        assertEquals(result, null);

    }

    @Test
    public void testHandleException() {
        // Given
        Throwable exception = new RuntimeException("Test exception");

        // When
        String result = serverController.handleException(exception);

        // Then
        assertEquals("Test exception", result);
    }

}