package baseball;

import baseball.controller.BaseballController;
import baseball.domain.BaseballGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballController baseballController = new BaseballController(new BaseballGame());
        baseballController.startGame();
    }
}
