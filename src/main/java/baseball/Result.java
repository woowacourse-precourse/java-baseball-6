package baseball;


public record Result(Integer strike, Integer ball) {
    private static final String INVALID_STRIKE_OR_BALL_COUNT = "스트라이크와 볼은 0보다 작을 수 없습니다.";
    private static final int ZERO = 0;

    public Result {
        if (strike < ZERO || ball < ZERO) {
            throw new IllegalArgumentException(INVALID_STRIKE_OR_BALL_COUNT);
        }
    }

    public boolean isAllStrike() {
        return strike == 3;
    }
}
