package baseball.domain.ball;

public class Number {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    private int number;

    public Number(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if(number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("1에서 9사이의 값을 입력해야합니다.");
        }
    }

    public boolean isSameNumber(Number inputNumber) {
        return inputNumber.number == this.number;
    }

    public int getNumber() {
        return number;
    }
}
