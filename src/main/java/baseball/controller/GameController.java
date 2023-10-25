package baseball.controller;

import baseball.utils.GameAnswerManager;

import static baseball.view.GameOutputView.printGameStartMessage;

public class GameController {

    private final GameAnswerManager gameAnswerManager;

    public GameController(GameAnswerManager gameAnswerManager) {
        this.gameAnswerManager = gameAnswerManager;
    }

    public void start() {
        printGameStartMessage();
        gameAnswerManager.setAnswer();
    }
}
