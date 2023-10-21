package baseball.controller;

import baseball.model.GameModel;
import baseball.view.GameView;

public class GameController {

    private GameModel model;
    private GameView view;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public void runGame() {
        view.showStartMessage();

        while (true) {
            String userInput = view.getUserInput();
            try {
                model.validateUserInput(userInput);
                System.out.println("임시 작동 중");
                break;
            } catch (IllegalArgumentException exception) {
                throw new IllegalArgumentException();
            }

        }
    }
}
