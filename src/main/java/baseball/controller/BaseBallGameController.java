package baseball.controller;

import baseball.BaseballGameMessage;
import baseball.service.BaseBallService;

import java.util.List;

public class BaseBallGameController {
    private final BaseBallService baseBallService;

    public BaseBallGameController() {
        baseBallService = new BaseBallService();
    }

    public void startGame() {
        System.out.println(BaseballGameMessage.START_GAME);

        List<Integer> targetNumber = baseBallService.generateRandomNumbers();
    }

}


