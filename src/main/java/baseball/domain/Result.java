package baseball.domain;

public class Result {

    private static final String STRIKE_WORD = "스트라이크";
    private static final String BALL_WORD = "볼 ";
    private static final String NOTHING_WORD = "낫싱";

    private final int strike;
    private final int ball;

    Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isAllHit() {
        return this.strike == 3;
    }

    private boolean isNothing() {
        return strike + ball == 0;
    }

    public String getValueToMessage() {
        if (this.isNothing()) return NOTHING_WORD;

        StringBuilder message = new StringBuilder();
        if (this.ball > 0) {
            message.append(this.ball).append(BALL_WORD);
        }
        if (this.strike > 0) {
            message.append(this.strike).append(STRIKE_WORD);
        }
        return message.toString();
    }
}
