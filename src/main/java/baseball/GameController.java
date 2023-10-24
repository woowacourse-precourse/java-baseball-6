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
        boolean isGameContinued = true;
        List<Integer> computerInput = gameComputing.generateComputerInput();
        gameView.printStart();
        while (isGameContinued) {
            List<Integer> userInput = gameInput.receiveInput();
            inputValidator.validateInput(userInput);
            int result = gameComputing.compute(computerInput, userInput);
            if (result == GAME_OVER) {
                isGameContinued  = gameView.askContinueGame();
                if (isGameContinued) {
                    computerInput = gameComputing.generateComputerInput();
                }
            }
        }
    }
}
