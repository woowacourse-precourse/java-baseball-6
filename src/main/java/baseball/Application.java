package baseball;

import baseball.controller.GameProcessController;
import baseball.view.MessageOutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MessageOutputView.gameStartMessage();
        ;
        GameProcessController gameProcess = new GameProcessController();
        gameProcess.startGame();
    }
}
