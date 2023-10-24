package baseball.controller;

import baseball.view.GameService;

public class BaseballGame {
    GameService gameService = new GameService();

    private static final int N = 3;

    public void startGame() {
        gameService.generateNdigitAnswer(N);
        gameService.printAnswer();
    }
}
