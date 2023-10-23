package baseball.domain;

public class GameHost {

    private boolean isGameDone;

    public void proceedGame() {
        BaseballGame baseballGame = this.generateNewGame();
        baseballGame.start();
    }

    public BaseballGame generateNewGame() {
        BaseballNumbers baseballNumbers = BaseballNumbers.generateBaseballNumbers();
        return new BaseballGame(baseballNumbers);
    }
}
