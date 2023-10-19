package baseball;

public class BallNumber {

    public static final int MIN_BALL_NUMBER = 1;
    public static final int MAX_BALL_NUMBER = 9;

    public BallNumber(final int number) {
        validate(number);
    }

    private void validate(final int number) {
        if (isOutOfBound(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isOutOfBound(final int number) {
        return number < MIN_BALL_NUMBER || number > MAX_BALL_NUMBER;
    }
}
