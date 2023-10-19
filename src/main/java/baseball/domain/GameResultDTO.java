package baseball.domain;

public class GameResultDTO {

    private final int ball;
    private final int strike;

    GameResultDTO(int ball, int strike) {
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
