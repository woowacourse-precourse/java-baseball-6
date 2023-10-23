package baseball.model;

public class BallNumber {
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;
    private int number;

    public BallNumber(int number) {
        validateBallNumberRange(number);
        this.number = number;
    }

    private void validateBallNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("공 번호는 1부터 9까지만 입력할 수 있습니다.");
        }
    }
}
