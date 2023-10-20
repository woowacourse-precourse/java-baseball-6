package baseball.game.validate;

public class NumberValidation {

    private static final String NONE_INTEGER = "정수를 입력하세요.";
    private static final String NEGATIVE_NUMBER = "숫자는 양수로 입력해주세요.";

    public static void validate(String number) {
        try {
            checkNegativeNumber(Integer.valueOf(number));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NONE_INTEGER);
        }
    }

    public static void checkNegativeNumber(Integer number) {
        if (number < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER);
        }
    }
}
