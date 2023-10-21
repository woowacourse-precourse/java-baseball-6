package baseball.dto;

public record Result(int ballCount, int strikeCount) {
    private static final int BASEBALLS_SIZE = 3;
    private static final int ZERO_COUNT = 0;
    private static final String NO_COUNT_MESSAGE = "낫싱";
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";

    @Override
    public final String toString() {
        if (ballCount == ZERO_COUNT && strikeCount == ZERO_COUNT) {
            return NO_COUNT_MESSAGE;
        }

        StringBuilder sb = new StringBuilder();
        if (ballCount != ZERO_COUNT) {
            sb.append(ballCount).append(BALL_MESSAGE);
        }

        if (strikeCount != ZERO_COUNT) {
            if (!sb.isEmpty()) {
                sb.append(" ");
            }
            sb.append(strikeCount).append(STRIKE_MESSAGE);
        }
        return sb.toString();
    }

    public final boolean isAllStrike() {
        return BASEBALLS_SIZE == strikeCount;
    }
}

