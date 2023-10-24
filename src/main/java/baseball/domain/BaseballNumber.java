package baseball.domain;


public class BaseballNumber {
    private final int value;

    public BaseballNumber(int value) {
        this.value = value;
    }

    public boolean isSameValue(BaseballNumber anotherNumber) {
        return this.value == anotherNumber.value;
    }
}
