package baseball;

public class BaseballNumber {

    private final int value;

    public BaseballNumber(int value) {
        validateValue(value);
        this.value = value;
    }

    private void validateValue(int value) {
        if (value < 1 || value > 9) {
            throw new IllegalArgumentException("Invalid number");
        }
    }

    public boolean isSameValue(BaseballNumber number) {
        return this.value == number.value;
    }
}
