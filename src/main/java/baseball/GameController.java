package baseball;

import java.util.List;

public class GameController {
    private GameView gameView;
    private GameInput gameInput;
    private GameComputing gameComputing;

    public GameController() {
        this.gameView = new GameView();
        this.gameInput = new GameInput();
        this.gameComputing = new GameComputing();
    }

    public void play() {
        boolean continueGame = true;
        List<Integer> computerInput = gameComputing.getComputerInput();
        gameView.printStart();
        while (continueGame) {
            List<Integer> userInput = gameInput.getInput();
            int result = gameComputing.compute(computerInput, userInput);
            if (result == 3) {
                continueGame = gameView.askContinueGame();
                computerInput = gameComputing.getComputerInput();
            }
        }
    }
}
