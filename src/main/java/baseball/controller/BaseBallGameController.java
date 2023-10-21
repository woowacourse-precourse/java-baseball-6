package baseball.controller;


import baseball.service.BaseBallService;

import java.util.List;

import static baseball.BaseballGameMessage.*;

public class BaseBallGameController {

    private final BaseBallService baseBallService;

    public BaseBallGameController() {
        baseBallService = new BaseBallService();
    }

    public void startGame() {
        System.out.println(START_GAME);

        List<Integer> targetNumber = baseBallService.generateRandomNumbers();
    }

}


