package baseball.controller;

import static baseball.util.NumberConstants.LIMIT_NUMBERS_SIZE;

import baseball.model.GameModel;
import baseball.util.CalculationResult;
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
                CalculationResult result = model.checkGameResult(userInput);
                System.out.println(view.showGameResult(result));
                if (result.getStrikeCnt() == LIMIT_NUMBERS_SIZE.getValue()) {
                    break;
                }
            } catch (IllegalArgumentException exception) {
                throw new IllegalArgumentException();
            }

        }
    }
}
