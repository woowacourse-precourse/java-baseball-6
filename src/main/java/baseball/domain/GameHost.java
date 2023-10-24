package baseball.domain;

import baseball.view.View;

public class GameHost {

    private boolean isGameDone;

    public void proceedGame() {
        while (!isGameDone) {
            BaseballGame baseballGame = this.generateNewGame();
            baseballGame.start();
            View.printGameEndMessage();
            this.askRestart();
        }
    }

    public BaseballGame generateNewGame() {
        BaseballNumbers baseballNumbers = BaseballNumbers.generateBaseballNumbers();
        return new BaseballGame(baseballNumbers);
    }

    public void askRestart() {
        GameControlCommand command = View.inputRestart();
        if (command.isEnd()) {
            isGameDone = true;
        }
    }
}
