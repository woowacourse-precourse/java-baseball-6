package baseball;

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
        boolean continueGame = true;
        List<Integer> computerInput = gameComputing.generateComputerInput();
        gameView.printStart();
        while (continueGame) {
            List<Integer> userInput = gameInput.receiveInput();
            inputValidator.validateInput(userInput);
            int result = gameComputing.compute(computerInput, userInput);
            if (result == GAME_OVER) {
                continueGame = gameView.askContinueGame();
                if (continueGame) {
                    computerInput = gameComputing.generateComputerInput();
                }
            }
        }
    }
}
