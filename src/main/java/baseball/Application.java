package baseball;

import baseball.controller.BaseballGameController;

public class Application {
    public static void main(String[] args) {
        // Controller 생성하고 게임 시작
        BaseballGameController controller = new BaseballGameController();
        controller.runGame();
    }
}
