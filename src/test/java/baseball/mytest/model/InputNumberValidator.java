package baseball.mytest.model;

public class InputNumberValidator {

    public void validateAllInput(String input) {
        hasThreeDigits(input);
        isNumber(input);
        isNumber(input);
        areDigitsUnique(input);
    }

    private void throwIAExceptionWithMessage(String message) {
        throw new IllegalArgumentException(message);
    }

    public boolean hasThreeDigits(String input) {
        if(input.length() != 3) {
            throwIAExceptionWithMessage("입력값은 3자리여야 합니다.");
        }
        return true;
    }

    public boolean isNumber(String input) {
        if(!input.matches("[+-]?\\d*(\\.\\d+)?")) {
            throwIAExceptionWithMessage("숫자만 입력해야 합니다.");
        }
        return true;
    }

    public boolean areDigitsUnique(String input) {
        if(input.length() != input.chars().distinct().count()){
            throwIAExceptionWithMessage("서로 다른 수들만 입력해야 합니다.");
        }
        return true;
    }

    public boolean isOneOrTwo(String input) {
        if(!input.equals("1") && !input.equals("2")){
            throwIAExceptionWithMessage("1 또는 2만 입력해야 합니다.");
        }
        return true;
    }
}
