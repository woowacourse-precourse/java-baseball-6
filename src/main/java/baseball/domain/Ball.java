package baseball.domain;

public class Ball {
    private static final String INVALID_RANGE_FORMAT = "%d에서 %d사이의 숫자를 입력해주세요";
    private static final String INVALID_POSITION_FORMAT = "%d에서 %d사이의 포지션을 입력해주세요";
    public static final int LOWER_LIMIT = 1;
    public static final int UPPER_LIMIT = 9;
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 3;

    private final int number;
    private final int position;

    public Ball(int number, int position) {
        validateNumber(number);
        validatePosition(position);
        this.number = number;
        this.position = position;
    }

    private void validateNumber(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(String.format(INVALID_RANGE_FORMAT, LOWER_LIMIT, UPPER_LIMIT));
        }
    }

    private void validatePosition(int position) {
        if (isInvalidPosition(position)) {
            throw new IllegalArgumentException(String.format(INVALID_POSITION_FORMAT, MIN_POSITION, MAX_POSITION));
        }
    }

    private static boolean isOutOfRange(int number) {
        return number < LOWER_LIMIT || number > UPPER_LIMIT;
    }

    private boolean isInvalidPosition(int position) {
        return position < MIN_POSITION || position > MAX_POSITION;
    }

    public boolean isStrike(Ball ball) {
        return number == ball.number && position == ball.position;
    }

    public boolean isBall(Ball ball) {
        return position != ball.position && number == ball.number;
    }
}
