package baseball.model;

public class BaseballNumber {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;

    private static final String ERROR_MESSAGE = "1 이상 9 이하 값을 가져야 합니다.";

    private final int number;

    public BaseballNumber(int number) {
        validateRange(number);

        this.number = number;
    }

    private static boolean isValidRange(int number) {
        return MIN_VALUE <= number && number <= MAX_VALUE;
    }

    private void validateRange(int number) {
        if (!isValidRange(number)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BaseballNumber that = (BaseballNumber) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
