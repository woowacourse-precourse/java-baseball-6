package baseball.util;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.constant.ConsoleMessage.*;
import static baseball.constant.ConsoleNumber.*;

public class Validation {
    public List<Integer> validateInputNum(String input) {
        validateInputLength(input);
        List<Integer> inputNums = changeStrToList(input);
        validateInputRange(inputNums);
        validateInputDuplicated(inputNums);

        return inputNums;
    }

    private List<Integer> changeStrToList(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void validateInputLength(String input) {
        if (input.length() != LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void validateInputRange(List<Integer> inputNums) {
        boolean checkRange = inputNums.stream()
                .allMatch(num -> FIRST_NUM <= num && num <= LAST_NUM);

        if (!checkRange) {
            throw new IllegalArgumentException();
        }
    }

    public void validateInputDuplicated(List<Integer> inputNums) {
        if (inputNums.stream().distinct().count() != LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void validateGameControlInput(int input) {
        if (input < RESTART_NUM || input > LAST_NUM) {
            throw new IllegalArgumentException();
        }
    }

    public void validateReGameInput() {
        throw new IllegalArgumentException();
    }
}

