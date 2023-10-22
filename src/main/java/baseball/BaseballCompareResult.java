package baseball;

public class BaseballCompareResult {

    private final int ball;
    private final int strike;

    public BaseballCompareResult(final int ball, final int strike) {
        validate(ball, strike);
        this.ball = ball;
        this.strike = strike;
    }

    private void validate(final int ball, final int strike) {
        if (!(0 <= ball && ball <= 3)) {
            throw new IllegalArgumentException("볼은 0 ~ 3 사이여야 합니다.");
        }
        if (!(0 <= strike && strike <= 3)) {
            throw new IllegalArgumentException("스트라이크는 0 ~ 3 사이여야 합니다.");
        }
        if (!(strike + ball <= 3)) {
            throw new IllegalArgumentException("스트라이크와 볼의 합은 0 ~ 3 사이여야 합니다.");
        }
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
