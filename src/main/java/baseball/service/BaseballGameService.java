package baseball.service;

import static baseball.utils.BaseballGameReaderUtils.askStartNewGame;

public class BaseballGameService {
    public static void startGame() {
        boolean isGameStart = true;
        while (isGameStart) {
            playBaseballGame();
            isGameStart = askStartNewGame();
        }
    }

    private static void playBaseballGame() {
        // TODO : implementation of baseball game logic
    }
}
