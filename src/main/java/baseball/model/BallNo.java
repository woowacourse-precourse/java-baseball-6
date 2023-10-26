package baseball.model;

public record BallNo(int number) {
    public static final int FIRST_NO = 1;
    public static final int END_NO = 9;
    private static final String WRONG_RANGE_OF_NUMBER = "[ERROR] 야구공은 1에서 9사이의 숫자만 가능합니다.";

    public BallNo {
        validate(number);
    }

    private void validate(int number) {
        if (number < FIRST_NO || number > END_NO) {
            throw new IllegalArgumentException(WRONG_RANGE_OF_NUMBER);
        }
    }
}
