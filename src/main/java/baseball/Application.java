package baseball;

import baseball.controller.GameController;
import baseball.model.GameModel;
import baseball.util.GameChoiceInputValid;
import baseball.util.GameInputValid;
import baseball.view.GameView;
import baseball.view.User;

public class Application {

    public static void main(String[] args) {

        User user = new User();
        GameInputValid inputValid = new GameInputValid();
        GameChoiceInputValid choiceInputValid = new GameChoiceInputValid();
        GameModel model = new GameModel(inputValid, choiceInputValid);
        GameView view = new GameView(user);
        GameController controller = new GameController(model, view);

        controller.runGame();

    }
}
