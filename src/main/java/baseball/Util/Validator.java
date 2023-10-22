package baseball.Util;

import java.util.List;

public class Validator {

    public Integer validateCommand(String input) {
        Integer command = isNumeric(input);
        if (command != 1 && command != 2) {
            throw new IllegalArgumentException("커맨드는 1 또는 2여야 합니다.");
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
            throw new IllegalArgumentException("입력된 수가 1-9 사이의 값이 아니거나 중복된 값이 있습니다.");
        }
    }

    private void validateSize(List<Integer> inputList) {
        if (inputList.size() != 3) {
            throw new IllegalArgumentException("정수는 총 3개 입력할 수 있습니다.");
        }
    }

    private Integer isNumeric(String input) {
        try {
            Integer number = Integer.parseInt(input);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력한 값이 정수가 아닙니다.");
        }
    }
}
