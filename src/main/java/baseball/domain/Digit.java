package baseball.domain;

public class Digit {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    private final int value;

    private Digit(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (!isValidate(value)) {
            throw new IllegalArgumentException("각 자릿수는 1~9 이어야 합니다");
        }
    }

    private boolean isValidate(int value) {
        return MIN_VALUE <= value && value <= MAX_VALUE;
    }

    public static Digit from(int value) {
        return new Digit(value);
    }
}
