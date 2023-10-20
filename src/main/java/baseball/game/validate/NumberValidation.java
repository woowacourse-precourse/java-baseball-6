package baseball.game.validate;

public class NumberValidation {

    private static final String NONE_NUMBER = "숫자가 입력되지 않았습니다.";
    private static final String NEGATIVE_NUMBER = "숫자는 양수로 입력해주세요.";

    public static void validate(String number) {
        try {
            checkNegativeNumber(Integer.valueOf(number));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NONE_NUMBER);
        }
    }

    public static void checkNegativeNumber(Integer number) {
        if (number < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER);
        }
    }
}
