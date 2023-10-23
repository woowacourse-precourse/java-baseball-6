package baseball.model;

public class InputNumberValidator {

    public String validateAllInput(String input) {
        hasThreeDigits(input);
        isNumber(input);
        isNumber(input);
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
        if (input.length() != 3) {
            throwIAExceptionWithMessage("입력값은 3자리여야 합니다.");
        }
    }

    private void isNumber(String input) {
        if (!input.matches("[+-]?\\d*(\\.\\d+)?")) {
            throwIAExceptionWithMessage("숫자만 입력해야 합니다.");
        }
    }

    private void areDigitsUnique(String input) {
        if (input.length() != input.chars().distinct().count()) {
            throwIAExceptionWithMessage("서로 다른 수들만 입력해야 합니다.");
        }
    }

    private void isOneOrTwo(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throwIAExceptionWithMessage("1 또는 2만 입력해야 합니다.");
        }
    }
}
