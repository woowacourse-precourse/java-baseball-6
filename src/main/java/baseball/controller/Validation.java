package baseball.controller;

import static baseball.constant.Message.INPUT_ASK_RESTART_EXCEPTION_MSG;
import static baseball.constant.Message.INPUT_DUPLICATE_EXCEPTION_MSG;
import static baseball.constant.Message.INPUT_LENGTH_EXCEPTION_MSG;
import static baseball.constant.Message.INPUT_RANGE_EXCEPTION_MSG;
import static baseball.constant.Number.END_NUM;
import static baseball.constant.Number.INPUT_LENGTH;
import static baseball.constant.Number.NUM_FIRST;
import static baseball.constant.Number.NUM_LAST;
import static baseball.constant.Number.RESTART_NUM;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        if (input.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException(INPUT_LENGTH_EXCEPTION_MSG);
        }
    }

    public void validateInputRange(List<Integer> inputNums) {
        boolean checkRange = inputNums.stream()
                .allMatch(num -> NUM_FIRST <= num && num <= NUM_LAST);

        if (!checkRange) {
            throw new IllegalArgumentException(INPUT_RANGE_EXCEPTION_MSG);
        }
    }

    public void validateInputDuplicated(List<Integer> inputNums) {
        if (inputNums.stream().distinct().count() != INPUT_LENGTH) {
            throw new IllegalArgumentException(INPUT_DUPLICATE_EXCEPTION_MSG);
        }
    }

    public void validateGameControlInput(int input) {
        if (input < RESTART_NUM || input > END_NUM) {
            throw new IllegalArgumentException(INPUT_ASK_RESTART_EXCEPTION_MSG);
        }
    }
}
