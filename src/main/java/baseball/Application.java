package baseball;

import baseball.domain.BaseBallGameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseBallGameController baseBallGameController = new BaseBallGameController();
        baseBallGameController.startGame();
    }
}
