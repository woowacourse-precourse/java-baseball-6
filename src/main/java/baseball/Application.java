package baseball;

import baseball.controller.GameFlowController;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameFlowController gameFlowController = new GameFlowController();
        gameFlowController.startGame();
    }
}
