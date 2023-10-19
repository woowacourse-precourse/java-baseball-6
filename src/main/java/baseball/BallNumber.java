package baseball;

public class BallNumber {

    public static final int MIN_BALL_NUMBER = 1;

    public static final int MAX_BALL_NUMBER = 9;

    private final int number;

    private final int position;

    public BallNumber(final int number, final int position) {
        validate(number);
        this.number = number;
        this.position = position;
    }

    private void validate(final int number) {
        if (isOutOfBound(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isOutOfBound(final int number) {
        return number < MIN_BALL_NUMBER || number > MAX_BALL_NUMBER;
    }

    public CompareResult compare(final BallNumber player) {
        return CompareResult.NOTHING;
    }
}
