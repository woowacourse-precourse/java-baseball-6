package baseball.response;

import baseball.domain.GameStatus;

public class GameResponse {

    private final GameStatus gameStatus;
    private final int strike;
    private final int ball;

    public GameResponse(GameStatus gameStatus, int strike, int ball) {
        this.gameStatus = gameStatus;
        this.strike = strike;
        this.ball = ball;
    }

    public boolean hasNoStrike() {
        return strike == 0;
    }

    public boolean hasNoBall() {
        return ball == 0;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
