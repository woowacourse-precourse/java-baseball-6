package baseball.controller;

import baseball.view.GameInput;
import baseball.view.GameView;
import baseball.validation.InputValidator;

import java.util.List;

public class GameController {
    private static final int GAME_OVER = 3;
    private GameView gameView;
    private GameInput gameInput;
    private GameComputing gameComputing;
    private InputValidator inputValidator;

    public GameController() {
        this.gameView = new GameView();
        this.gameInput = new GameInput();
        this.gameComputing = new GameComputing();
        this.inputValidator = new InputValidator();
    }

    public void play() {
        boolean isGameContinued = true;
        List<Integer> computer = gameComputing.generateComputerInput();
        gameView.printStart();
        while (isGameContinued) {
            List<Integer> player = gameInput.receiveInput();
            inputValidator.validateInput(player);
            int result = gameComputing.compute(computer, player);
            if (isGameOver(result)) {
                isGameContinued  = gameView.askContinueGame();
                if (isGameContinued) {
                    computer = gameComputing.generateComputerInput();
                }
            }
        }
    }

    private boolean isGameOver(int result) {
        return result == GAME_OVER;
    }
}
