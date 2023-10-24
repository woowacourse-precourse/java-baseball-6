package baseball;

import baseball.controller.GameController;
import baseball.model.GameModel;
import baseball.model.Result;
import baseball.view.GameView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        GameModel model = new GameModel(new Result(), true, true);
        GameView view = new GameView();

        GameController controller = new GameController(model, view);

        controller.playGame();
    }
}
