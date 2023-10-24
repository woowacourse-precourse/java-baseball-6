package baseball;

import baseball.controller.PlayGameController;

public class Application {
    private static final PlayGameController playGameController = new PlayGameController();

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        playGameController.playGame();
    }
}
