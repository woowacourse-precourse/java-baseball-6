package baseball.controller;

import baseball.model.ValidateMessage;

import java.util.List;

public class ValidateController {
    public void validateInputString(String input, Integer length) {
        if (input.length() != length) { // 숫자 길이 검사
            throw new IllegalArgumentException(String.format(ValidateMessage.ERROR_INPUT_NUMBER_LENGTH, length));
        }

        for (String inputAtOne : input.split("")) { // 문자가 아닌 숫자를 입력했는지 검사
            if (!ValidateMessage.numbers.contains(inputAtOne)) {
                throw new IllegalArgumentException(ValidateMessage.ERROR_INPUT_NUMBER_RANGE);
            }
        }
    }

    public void validateInputString(String input) throws IllegalArgumentException{
        if (input.length() != 1) { // 길이 검사
            throw new IllegalArgumentException(ValidateMessage.ERROR_INPUT_END_OR_RESTART_LENGTH);
        }
        if (!ValidateMessage.validEndOrRestartInput.contains(input)) { // 1, 2 이외의 숫자나 문자를 입력했는지 검사
            throw new IllegalArgumentException(ValidateMessage.ERROR_INPUT_END_OR_RESTART_RANGE);
        }
    }

    public void validateInputIntegerList(List<Integer> input, Integer length) {
        if (input.size() != length) {
            throw new IllegalArgumentException(ValidateMessage.ERROR_INPUT_NUMBER_HAS_DUPLICATE);
        }
    }
}
