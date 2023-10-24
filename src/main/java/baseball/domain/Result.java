package baseball.domain;

public enum Result {

    // TODO: 클래스로 변경할 것
    THREE_STRIKE(3, 0),
    TWO_STRIKE(2, 0),
    ONE_STRIKE(1, 0),
    ONE_STRIKE_TWO_BALL(1, 2),
    ONE_STRIKE_ONE_BALL(1, 1),
    THREE_BALL(0, 3),
    TWO_BALL(0, 2),
    ONE_BALL(0, 1),
    NOTHING(0, 0);

    private static final String STRIKE_WORD = "스트라이크";
    private static final String BALL_WORD = "볼 ";
    private static final String NOTHING_WORD = "낫싱";

    private final Integer strike;
    private final Integer ball;

    Result(Integer strike, Integer ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static Result of(int strike, int ball) {
        for (Result result : Result.values()) {
            if (result.strike == strike && result.ball == ball) {
                return result;
            }
        }
        throw new IllegalArgumentException("hit 결과를 Result로 매핑하는데 실패함.");
    }

    public boolean isThreeStrike() {
        return this == THREE_STRIKE;
    }

    public String getValueToMessage() {
        StringBuilder message = new StringBuilder();
        if (this == NOTHING) return NOTHING_WORD;

        if (this.ball > 0) {
            message.append(this.ball).append(BALL_WORD);
        }
        if (this.strike > 0) {
            message.append(this.strike).append(STRIKE_WORD);
        }
        return message.toString();
    }
}
