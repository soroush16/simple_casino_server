package com.assignment.service;

import com.assignment.dto.PlayerMessage;
import com.assignment.dto.Result;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class GameService {

    public Result playGameLogic(PlayerMessage playerMessage) {
        double win = 0;
        Result result;
        int randomNumber = getRandomNumber();
        if (playerMessage.getNumber() > randomNumber) {
            win = (playerMessage.getBet()) * (99.0 / (100.0 - playerMessage.getNumber()));
        }
        if(win==0){
            result = new Result("you lost",null);
        }else{
            result = new Result("Win", Optional.of(win));
        }
        return  result;
    }

    public int getRandomNumber() {
        Random rn = new Random();
        return rn.nextInt(1, 100);
    }
}
