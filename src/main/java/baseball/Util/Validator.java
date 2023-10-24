package baseball.Util;

import baseball.constants.ErrorCode;
import baseball.constants.Baseball;

import java.util.List;

public class Validator {

    public Integer validateCommand(String input) {
        Integer command = isNumeric(input);
        if (command != Baseball.RESTART.getValue() && command != Baseball.QUIT.getValue()) {
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
                .filter(a -> Baseball.MIN_NUMBER.getValue() <= a
                        && a <= Baseball.MAX_NUMBER.getValue())
                .distinct()
                .toList();
        if (intList.size() != inputList.size()) {
            throw new IllegalArgumentException(ErrorCode.INVALID_INPUT.toString());
        }
    }

    private void validateSize(List<Integer> inputList) {
        if (inputList.size() != Baseball.MAX_SIZE.getValue()) {
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
