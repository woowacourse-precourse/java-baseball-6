package baseball;

public class BaseballNumber {

    private final int value;

    public BaseballNumber(int value) {
        validateValue(value);
        this.value = value;
    }

    private void validateValue(int value) {
        if (value < 1 || value > 9) {
            throw new IllegalArgumentException("유효하지 않은 숫자");
        }
    }

    public boolean isSameValue(BaseballNumber number) {
        return this.value == number.value;
    }
}
