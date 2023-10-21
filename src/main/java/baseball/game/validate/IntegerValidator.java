package baseball.game.validate;

public class IntegerValidator {
    private static final String NONE_INTEGER = "정수를 입력하세요.";

    public static void validate(String number) {
        try {
            Integer.valueOf(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NONE_INTEGER);
        }
    }
}
