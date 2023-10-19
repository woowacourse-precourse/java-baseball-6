package baseball.domain;

public class GameNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final String RANGE_EXCEPTION_MESSAGE =
            String.format("Error : 각 자리수는 %d ~ %d 사이의 숫자여야 합니다.", MIN_NUMBER, MAX_NUMBER);

    private final int number;

    public GameNumber(int number) {
        this.number = number;
        validateRange();
    }

    private void validateRange() {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(RANGE_EXCEPTION_MESSAGE);
        }
    }
}
