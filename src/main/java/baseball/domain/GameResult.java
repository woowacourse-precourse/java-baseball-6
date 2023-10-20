package baseball.domain;

public class GameResult {
    private final int ball;
    private final int strike;
    private final GameStatus gameStatus;

    public GameResult(int ball, int strike, GameStatus gameStatus) {
        this.ball = ball;
        this.strike = strike;
        this.gameStatus = gameStatus;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
