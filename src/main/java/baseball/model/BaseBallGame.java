package baseball.model;

public class BaseBallGame {

    private final BaseBallNumbers computerNumbers;
    private boolean gameOver;

    private BaseBallGame(boolean gameOver, BaseBallNumbers computerNumbers) {
        this.gameOver = gameOver;
        this.computerNumbers = computerNumbers;
    }

    public static BaseBallGame create(BaseBallNumbers computerNumbers) {
        return new BaseBallGame(false, computerNumbers);
    }

    public BaseBallGameResult determineGameResult(BaseBallNumbers playerNumbers) {
        BaseBallGameResult baseBallGameResult = computerNumbers.evaluateGameResult(playerNumbers);
        gameOver = baseBallGameResult.isGameEnd();
        return baseBallGameResult;
    }

    public boolean isInProgress() {
        return !gameOver;
    }

}
