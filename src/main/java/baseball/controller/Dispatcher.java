package baseball.controller;

import baseball.dto.JudgeDTO;

public class Dispatcher {

    private static Dispatcher INSTANCE;
    private Dispatcher(GameController gameController) {
        this.gameController = gameController;
    }
    public static Dispatcher getInstance(GameController gameController) {
        if (INSTANCE == null)
            INSTANCE = new Dispatcher(gameController);
        return INSTANCE;
    }

    private final GameController gameController;

    public void dispatchGameStart() {
        gameController.start();
    }

    public JudgeDTO dispatchProcess(String input) {
        return gameController.process(input);
    }

    public boolean dispatchRetry(String input) {
        return gameController.isRetry(input);
    }

}
