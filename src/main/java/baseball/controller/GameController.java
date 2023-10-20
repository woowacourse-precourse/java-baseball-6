package baseball.controller;

import baseball.model.GameModel;
import baseball.util.GameInputValid;
import baseball.view.GameView;

public class GameController {

    private GameModel model;
    private GameView view;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public void runGame() {
        GameInputValid userInputValid = new GameInputValid();
        view.showStartMessage();

        while (true) {
            String userInput = view.getUserInput();
            try {
                userInputValid.inputValid(userInput);
            } catch (IllegalArgumentException exception) {
                throw new IllegalArgumentException();
            }

        }
    }
}
