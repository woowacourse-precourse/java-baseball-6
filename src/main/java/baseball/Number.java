package baseball;

public record Number(int number) {

    private static final int MIN_NUMBER = 1;

    private static final int MAX_NUMBER = 9;

    public Number {
        validate(number);
    }

    private void validate(final int number) {
        if (isOutOfBound(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isOutOfBound(final int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    public static Number of(final int number) {
        return new Number(number);
    }
}
