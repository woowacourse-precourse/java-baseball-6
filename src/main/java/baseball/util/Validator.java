package baseball.util;

public abstract class Validator {

    public abstract void validate(String inputNum) throws IllegalArgumentException;

    // 공백 제거
    static String removeSpace(String inputNum) {
        return inputNum.replace(" ", "");
    }

    static void validateEmptyInput(String inputNum) {
        if(inputNum.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RESTART_INPUT_NUM.getErrorMessage());
        }
    }

}
