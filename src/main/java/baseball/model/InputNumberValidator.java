package baseball.model;

public class InputNumberValidator {
    private static final InputNumberValidator singleton = new InputNumberValidator();
    public static final int VALID_DIGIT_LENGTH = 3;
    private static final String HAS_THREE_DIGITS_MESSAGE = "입력값은 3자리여야 합니다.";
    private static final String IS_ONE_TO_NINE_NUMBER_MESSAGE = "1부터 9까지의 자연수만 입력해야 합니다.";
    private static final String ARE_DIGITS_UNIQUE_MESSAGE = "서로 다른 수들만 입력해야 합니다.";
    private static final String IS_ONE_OR_TWO_MESSAGE = "1 또는 2만 입력해야 합니다.";
    public static final String NUMBER_REGEX = "^[1-9]{3}$";

    private InputNumberValidator() {
    }

    public static InputNumberValidator getInstance() {
        return singleton;
    }

    public String validateAllInput(String input) {
        hasThreeDigits(input);
        isOneToNineNumber(input);
        areDigitsUnique(input);
        return input;
    }

    public String validateRestartInput(String input) {
        isOneOrTwo(input);
        return input;
    }

    private void throwIAExceptionWithMessage(String message) {
        throw new IllegalArgumentException(message);
    }

    private void hasThreeDigits(String input) {
        if (input.length() != VALID_DIGIT_LENGTH) {
            throwIAExceptionWithMessage(HAS_THREE_DIGITS_MESSAGE);
        }
    }

    private void isOneToNineNumber(String input) {
        if (!input.matches(NUMBER_REGEX)) {
            throwIAExceptionWithMessage(IS_ONE_TO_NINE_NUMBER_MESSAGE);
        }
    }

    private void areDigitsUnique(String input) {
        if (input.length() != input.chars().distinct().count()) {
            throwIAExceptionWithMessage(ARE_DIGITS_UNIQUE_MESSAGE);
        }
    }

    private void isOneOrTwo(String input) {
        String restart = GameRestartOption.RESTART.getValue();
        String quit = GameRestartOption.QUIT.getValue();

        if (!input.equals(restart) && !input.equals(quit)) {
            throwIAExceptionWithMessage(IS_ONE_OR_TWO_MESSAGE);
        }
    }
}