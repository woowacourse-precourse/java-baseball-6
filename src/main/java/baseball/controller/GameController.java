package baseball.controller;

import static baseball.util.NumberConstants.LIMIT_NUMBERS_SIZE;

import baseball.model.GameModel;
import baseball.util.CalculationResult;
import baseball.view.GameView;

public class GameController {

    private final GameModel model;
    private final GameView view;
    private boolean systemOnOff;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
        this.systemOnOff = true;
    }

    public void runGame() {
        view.showStartMessage();

        while (systemOnOff) {
            playGame();
        }
    }

    private void playGame() {
        String userInput = view.getUserInput();
        try {
            model.validateUserInput(userInput);
            CalculationResult result = model.checkGameResult(userInput);
            System.out.println(view.showGameResult(result));
            if (result.getStrikeCnt() == LIMIT_NUMBERS_SIZE.getValue()) {
                gameChoice();
            }
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException();
        }
    }

    private void gameChoice() {
        String userChoice = view.getGameChoiceInput();
        model.validateUserChoice(userChoice);
        switch (userChoice) {
            case "1":
                model.reset();
                view.showStartMessage();
                break;
            case "2":
                systemOnOff = false;
                break;
        }
    }
}
