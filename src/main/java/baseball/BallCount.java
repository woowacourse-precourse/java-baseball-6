package baseball;

public record BallCount(long strike, long ball) {

    public static final long NO_COUNT = 0L;
    public static final long MAX_OF_STRIKE = 3L;

    public static final String NOTHING = "낫싱";
    public static final String BALL = "볼 ";
    public static final String STRIKE = "스트라이크";


    public boolean isFullCount() {
        return strike == MAX_OF_STRIKE;
    }

    @Override
    public String toString() {
        if (ball == NO_COUNT && strike == NO_COUNT) {
            return NOTHING;
        }

        String result = "";
        if (ball != NO_COUNT) {
            result += ball + BALL;
        }
        if (strike != NO_COUNT) {
            result += strike + STRIKE;
        }
        return result;
    }
}
