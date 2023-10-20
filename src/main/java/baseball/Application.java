package baseball;

import baseball.controller.GameController;
import baseball.model.GameModel;
import baseball.view.GameView;
import baseball.view.User;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();
        GameModel model = new GameModel();
        GameView view = new GameView(user);
        GameController controller = new GameController(model, view);

        controller.runGame();

    }
}
