package baseball;

import baseball.controller.GameController;
import baseball.model.rule.BallRule;
import baseball.model.rule.StrikeRule;
import baseball.view.input.ConsoleInputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController(
                new ConsoleInputView(),
                new BallRule(),
                new StrikeRule());
        gameController.playBaseball();
    }
}
