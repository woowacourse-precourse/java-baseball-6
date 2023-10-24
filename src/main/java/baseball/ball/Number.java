package baseball.ball;

public class Number {
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 9;
    private final int number;

    public Number(int number) {
        validateRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean isEqualTo(Number otherNumber) {
        return number == otherNumber.getNumber();
    }

    public void validateRange(int number) {
        if (number < MINIMUM_NUMBER || MAXIMUM_NUMBER < number) {
            throw new IllegalArgumentException("[ERROR] 숫자 범위를 벗어났습니다.");
        }
    }
}
