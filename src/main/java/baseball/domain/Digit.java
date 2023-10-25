package baseball.domain;

public class Digit {

    static final int MIN_VALUE = 1;
    static final int MAX_VALUE = 9;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Digit digit = (Digit) o;
        return value == digit.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("Digit{value=%d}", value);
    }
}
