package baseball;

import baseball.controller.BaseballController;
import baseball.entity.Ball;
import baseball.entity.GameResult;
import baseball.entity.Strike;
import baseball.model.BaseballModel;
import baseball.view.BaseballView;

public class Application {
    public static void main(String[] args) {
        Strike strike = new Strike();
        Ball ball = new Ball();
        GameResult gameResult = new GameResult(strike, ball, false);
        BaseballModel baseballModel = new BaseballModel(gameResult);
        BaseballView baseballView = new BaseballView();
        BaseballController baseballController = new BaseballController(baseballModel, baseballView);
        baseballController.startGame();
    }
}
