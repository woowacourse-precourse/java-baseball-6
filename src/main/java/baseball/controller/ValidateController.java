package baseball.controller;

public class ValidateController {
    private final String numbers = "123456789";
    private final String validEndOrRestartInput = "12";
    private final String ERROR_INPUT_NUMBER_RANGE = "1에서 9 사이의 숫자만 가능합니다.";
    private final String ERROR_INPUT_NUMBER_LENGTH = "길이 %d의 숫자이어야 합니다.";
    private final String ERROR_INPUT_END_OR_RESTART_RANGE = "1 또는 2의 숫자만 가능합니다.";
    private final String ERROR_INPUT_END_OR_RESTART_LENGTH = "한 개의 숫자만 입력 가능합니다.";
    public void validateInputString(String input, Integer length) {
        if (input.length() != length) {
            throw new IllegalArgumentException(String.format(ERROR_INPUT_NUMBER_LENGTH, length));
        }

        for (String inputAtOne : input.split("")) {
            if (numbers.indexOf(inputAtOne) == -1) {
                throw new IllegalArgumentException(ERROR_INPUT_NUMBER_RANGE);
            }
        }
    }

    public void validateInputString(String input) throws IllegalArgumentException{
        if (input.length() != 1) {
            throw new IllegalArgumentException(ERROR_INPUT_END_OR_RESTART_LENGTH);
        }
        if (validEndOrRestartInput.indexOf(input) == -1) {
            throw new IllegalArgumentException(ERROR_INPUT_END_OR_RESTART_RANGE);
        }
    }
}
