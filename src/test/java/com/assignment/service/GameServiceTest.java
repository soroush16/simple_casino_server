package com.assignment.service;

import com.assignment.dto.PlayerMessage;
import com.assignment.dto.Result;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

class GameServiceTest {

    GameService gameService = new GameService();

    @Test
    public void testPlayGameLogic_PlayerWins() {
        // Given
        PlayerMessage playerMessage = new PlayerMessage(75, 10);
        GameService gameServiceStub = spy(GameService.class);

        // When
        when(gameServiceStub.getRandomNumber()).thenReturn(5);
        Result result = gameServiceStub.playGameLogic(playerMessage);
        // Then
        assertEquals("win", result.getTitle());
        assertTrue(result.getWin() > 0);
        assertEquals(82.5, result.getWin());
    }

    @Test
    public void testPlayGameLogic_PlayerLooses() {
        // Given
        PlayerMessage playerMessage = new PlayerMessage(75, 10);
        GameService gameServiceStub = spy(GameService.class);

        // When
        when(gameServiceStub.getRandomNumber()).thenReturn(15);
        Result result = gameServiceStub.playGameLogic(playerMessage);
        // Then
        assertEquals(result.getWin(), 0);
        assertEquals("win", result.getTitle());

    }

    @Test
    public void testGetRandomNumber_isBetweenOneAndHundred() {
        //Given,When
        int randomNumber = gameService.getRandomNumber();
        //Then
        assertTrue(randomNumber > 0);
        assertTrue(randomNumber < 100);
    }
}