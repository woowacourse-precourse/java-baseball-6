package baseball.game.validate;

public class NegativeNumberValidator {

    private static final String NEGATIVE_NUMBER = "숫자는 양수로 입력해주세요.";

    public static void validate(Integer number) {
        if (number < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER);
        }
    }
}
