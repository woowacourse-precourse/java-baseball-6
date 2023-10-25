package baseball;

import baseball.controller.BaseballGameController;
import baseball.model.BaseballGameModel;
import baseball.view.BaseballGameView;

public class Application {

    public static void main(String[] args) {

        BaseballGameModel baseballGameModel = new BaseballGameModel();
        BaseballGameView baseballGameView = new BaseballGameView();

        BaseballGameController baseballGameController = new BaseballGameController(
            baseballGameModel, baseballGameView);
        baseballGameController.playGame();

    }
}
