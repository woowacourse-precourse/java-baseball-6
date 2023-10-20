package baseball.view;

import baseball.model.GameResult;

import static baseball.view.BaseballConsoleConstants.GAME_OVER;
import static baseball.view.BaseballConsoleConstants.START_BASEBALL_GAME;

public class OutputView {
    public void printStartGameMessage() {
        BaseballConsole.print(START_BASEBALL_GAME);
    }
    public void printGameResult(GameResult gameResult) {
        BaseballConsole.print(gameResult.toString());
    }
    public void printGameOverMessage() {
        BaseballConsole.print(GAME_OVER);
    }
}
