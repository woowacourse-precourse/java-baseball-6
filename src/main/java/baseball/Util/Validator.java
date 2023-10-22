package baseball.Util;

import baseball.constants.ErrorCode;

import java.util.List;

public class Validator {

    public Integer validateCommand(String input) {
        Integer command = isNumeric(input);
        if (command != 1 && command != 2) {
            throw new IllegalArgumentException(ErrorCode.INVALID_COMMAND.toString());
        }
        return command;
    }

    public void validateInput(List<Integer> inputList) {
        validateSize(inputList);
        validateRangeAndUnique(inputList);
    }

    private void validateRangeAndUnique(List<Integer> inputList) {
        List<Integer> intList = inputList.stream()
                .filter(a -> 1 <= a && a <= 9)
                .distinct()
                .toList();
        if (intList.size() != inputList.size()) {
            throw new IllegalArgumentException(ErrorCode.INVALID_INPUT.toString());
        }
    }

    private void validateSize(List<Integer> inputList) {
        if (inputList.size() != 3) {
            throw new IllegalArgumentException(ErrorCode.INVALID_SIZE.toString());
        }
    }

    private Integer isNumeric(String input) {
        try {
            Integer number = Integer.parseInt(input);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.NOT_NUMERIC.toString());
        }
    }
}
