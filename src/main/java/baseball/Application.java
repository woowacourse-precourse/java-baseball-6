package baseball;

import baseball.Controller.BaseballGameController;
import baseball.Model.BaseballGameModel;
import baseball.View.BaseballGameView;

public class Application {
    public static void main(String[] args) {
        BaseballGameModel model = new BaseballGameModel();
        BaseballGameView view = new BaseballGameView();
        BaseballGameController controller = new BaseballGameController(model, view);

        controller.playGame();
    }
}

