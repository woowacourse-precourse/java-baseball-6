package baseball.number;

import java.util.Objects;

public class Number {
    private final int number;

    public Number(int number) {
        validate(String.valueOf(number));
        this.number = number;
    }

    public Number(String number) {
        validate(number);
        this.number = Integer.parseInt(number);
    }

    private void validate(String numberText) {
        validateNumber(numberText);
        validateRange(numberText);
    }

    private void validateNumber(String numberText) {
        try {
            Integer.parseInt(numberText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private static void validateRange(String numberText) {
        int number = Integer.parseInt(numberText);
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("1부터 9까지의 숫자만 입력 가능합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
