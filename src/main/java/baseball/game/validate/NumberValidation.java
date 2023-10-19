package baseball.game.validate;

public class NumberValidation {

    private static final String NONE_NUMBER = "숫자가 입력되지 않았습니다.";

    public static void validate(String number) {
        try {
            Integer.valueOf(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NONE_NUMBER);
        }
    }
}
