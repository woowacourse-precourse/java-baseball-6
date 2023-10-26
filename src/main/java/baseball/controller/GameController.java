package baseball.controller;

import baseball.model.BaseBallGamePlayer;
import baseball.model.BaseballGameRule;
import baseball.model.Computer;
import baseball.model.Hint;
import baseball.model.ball.Balls;
import java.util.List;

public class GameController extends BaseballGameRule {
    private final OutputController outputController;
    private final InputController inputController;
    private final Computer gameComputer;
    private final BaseBallGamePlayer baseBallGamePlayer;

    private GameController() {
        this.outputController = new OutputController();
        this.inputController = new InputController();
        this.gameComputer = new Computer();
        this.baseBallGamePlayer = new BaseBallGamePlayer();
    }
    public static GameController StartBaseballGame() {
        return new GameController();
    }
    public void startGame() {
        outputController.showIntroMessage();
        Integer gameProcess = PLAY_BASEBALL_GAME;
        while (gameProcess.equals(PLAY_BASEBALL_GAME)) {
            Balls answer = gameComputer.initBallsForGame(gameComputer.pickNumbers());
            playSingleGame(answer);
            outputController.showGameRestartInputMessage();
            gameProcess = inputController.getPlayerRestartNumber();
        }
    }

    public void playSingleGame(Balls answer) {
        boolean allBallsHit = false;
        while (!allBallsHit) {
            outputController.showGameInputMessage();
            List<Integer> numberPicked = inputController.getPlayerGuessNumber();
            baseBallGamePlayer.generateBalls(numberPicked);
            Hint gameResult = baseBallGamePlayer.guessBalls(answer);
            outputController.displayHint(gameResult);
            allBallsHit = gameResult.isAllStrike();
        }
        outputController.showGameClearMessage();
    }
}
