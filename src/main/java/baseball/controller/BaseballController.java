package baseball.controller;


import baseball.service.BaseballService;

import static global.Constants.*;

public class BaseballController {

    BaseballService baseballService = new BaseballService();

    public void run() {
        initGame();
        startGame();
        endGame();
        retry();
    }

    private void initGame() {
        baseballService.initGame(SIZE, START_NUMBER, END_NUMBER);
    }

    private void startGame() {
        baseballService.startGame();
    }

    private void endGame() {
        baseballService.endGame();
    }

    private void retry() {
        if(baseballService.askRetry()) run();
    }
}
