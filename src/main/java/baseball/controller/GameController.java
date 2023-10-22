package baseball.controller;

import baseball.model.BaseBallGameComputer;
import baseball.model.BaseballGamePlayer;
import baseball.model.Hint;
import java.util.List;

public class GameController {
    private final OutputController outputController;
    private final InputController inputController;
    private final BaseBallGameComputer gameComputer;

    private GameController() {
        this.outputController = new OutputController();
        this.inputController = new InputController();
        this.gameComputer = new BaseBallGameComputer();
    }

    public static GameController StartBaseballGame() {
        return new GameController();
    }

    public void startNewGame() {
        boolean gameProcess = true;
        while (gameProcess) {
            outputController.showIntroMessage();
            gameComputer.readyForGame();
            playGame();
            outputController.showGameRestartInputMessage();
            gameProcess = inputController.isRestartGame();
        }
    }

    public void playGame() {
        boolean isGameClear = false;
        while (!isGameClear) {
            outputController.showGameInputMessage();
            List<Integer> input = inputController.getPlayerGuessNumber();
            Hint result = BaseballGamePlayer.swingBat(gameComputer, input);
            isGameClear = outputController.displayHint(result);
        }
    }
}
