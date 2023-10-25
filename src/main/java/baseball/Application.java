package baseball;

import baseball.controller.BaseballGameController;
import baseball.model.BaseballGameModel;
import baseball.view.BaseballGameView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGameModel model = new BaseballGameModel();
        BaseballGameView view = new BaseballGameView();
        BaseballGameController controller = new BaseballGameController(model, view);

        controller.startGame();
    }
}
