package baseball;

import baseball.controller.GameProgress;

public class Application {
    public static void main(String[] args) {
        GameProgress gameProgress = new GameProgress();
        gameProgress.startGame();
    }
}