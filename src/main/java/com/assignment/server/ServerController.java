package com.assignment.server;

import com.assignment.dto.PlayerMessage;
import com.assignment.dto.Result;
import com.assignment.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import javax.validation.Valid;


@Controller
public class ServerController {
    private GameService gameService;

    @Autowired
    public ServerController(GameService gameService) {
        this.gameService = gameService;
    }

    @MessageMapping("/process-message")
    @SendToUser("/queue/reply")
    public Result processMessage(@Valid PlayerMessage playerMessage) {
        return gameService.playGameLogic(playerMessage);
    }

    @MessageExceptionHandler
    @SendToUser("/queue/errors")
    public String handleException(Throwable exception) {
        return exception.getMessage();
    }

}
