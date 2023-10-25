package baseball.vo;

public class BaseballGameResultDTO {
    private BaseballGameResultStatus gameStatus;
    private int ball;
    private int strike;

    public BaseballGameResultDTO(BaseballGameResultStatus gameStatus, int ball, int strike) {
        this.gameStatus = gameStatus;
        this.ball = ball;
        this.strike = strike;
    }

    public BaseballGameResultStatus getGameStatus() {
        return gameStatus;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
