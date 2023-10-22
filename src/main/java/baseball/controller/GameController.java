package baseball.controller;

import baseball.model.BaseballGameComputer;
import baseball.model.BaseballGamePlayer;
import baseball.model.Hint;
import baseball.model.rule.BaseBallGameRule;
import java.util.List;

public class GameController extends BaseBallGameRule {
    private final OutputController outputController;
    private final InputController inputController;
    private final BaseballGameComputer gameComputer;

    private GameController() {
        this.outputController = new OutputController();
        this.inputController = new InputController();
        this.gameComputer = new BaseballGameComputer();
    }

    public static GameController StartBaseballGame() {
        return new GameController();
    }

    public void startNewGame() {
        Integer gameProcess = PLAY_BASEBALL_GAME;
        while (gameProcess.equals(PLAY_BASEBALL_GAME)) {
            outputController.showIntroMessage();
            gameComputer.readyForGame();
            playGame();
            outputController.showGameRestartInputMessage();
            gameProcess = inputController.getPlayerRestart();
        }
    }

    public void playGame() {
        boolean allBallsNotHit = true;
        while (allBallsNotHit) {
            outputController.showGameInputMessage();
            List<Integer> input = inputController.getPlayerGuessNumber();
            Hint result = BaseballGamePlayer.swingBat(gameComputer, input);
            allBallsNotHit = outputController.displayHint(result);
        }
    }
}
