package baseball.Controller;

import baseball.Model.BaseballGame;
import baseball.View.ConsoleView;

public class BaseballController {
    public static final String RESTART_GAME = "1";
    public static final String CLOSE_GAME = "2";
    private final ConsoleView consoleView;
    private final BaseballGame baseballGame;

    public BaseballController() {
        baseballGame = new BaseballGame();
        consoleView = new ConsoleView();
        consoleView.printStartGame();
    }

    public void startGame() {
        baseballGame.initializeSetting();
        while (baseballGame.strike != 3) {
            consoleView.printRequestUserNum();
            String userNum = consoleView.getUserNum();
            baseballGame.tryStrike(userNum);
            consoleView.printBallAndStrike(baseballGame.ball, baseballGame.strike);
        }
        consoleView.printEndMessage();
        restartGame();
    }

    public void restartGame() {
        consoleView.printNewGame();
        String replayChoose = consoleView.getReplayNum();
        if (replayChoose.equals(RESTART_GAME)) {
            startGame();
        }
        if (replayChoose.equals(CLOSE_GAME)) {
            return;
        }
    }
}

