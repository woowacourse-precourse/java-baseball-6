package baseball.controller;

import static baseball.util.NumberConstants.LIMIT_NUMBERS_SIZE;

import baseball.model.GameModel;
import baseball.util.CalculationResult;
import baseball.view.GameView;

public class GameController {

    private GameModel model;
    private GameView view;
    private boolean systemOnOff;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
        this.systemOnOff = true;
    }

    public void runGame() {
        view.showStartMessage();

        while (systemOnOff) {
            String userInput = view.getUserInput();
            try {
                model.validateUserInput(userInput);
                CalculationResult result = model.checkGameResult(userInput);
                System.out.println(view.showGameResult(result));
                if (result.getStrikeCnt() == LIMIT_NUMBERS_SIZE.getValue()) {
                    String userChoice = view.getGameChoiceInput();
                    model.validateUserChoice(userChoice);
                    switch (userChoice) {
                        case "1":
                            model.reset();
                            view.showStartMessage();
                            continue;
                        case "2":
                            systemOnOff = false;
                            break;
                    }
                }
            } catch (IllegalArgumentException exception) {
                throw new IllegalArgumentException();
            }

        }
    }
}
