package baseball.domain;

public class GameResultDTO {
    int ball;
    int strike;

    public GameResultDTO(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
