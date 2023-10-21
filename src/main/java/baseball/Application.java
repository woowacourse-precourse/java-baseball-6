package baseball;

import baseball.controller.GameController;
import baseball.model.BallRule;
import baseball.model.StrikeRule;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController(new BallRule(), new StrikeRule());
        gameController.playBaseball();
    }
}
