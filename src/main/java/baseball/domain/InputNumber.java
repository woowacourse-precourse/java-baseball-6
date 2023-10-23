package baseball.domain;

import java.util.List;

import static baseball.util.ExceptionMessage.*;

public class InputNumber {

    private final List<Integer> inputNumber;

    public static InputNumber create(List<Integer> inputNumber) {
        return new InputNumber(inputNumber);
    }

    private InputNumber(List<Integer> inputNumber) {
        validateInputNumber(inputNumber);
        this.inputNumber = inputNumber;
    }

    private void validateInputNumber(List<Integer> inputNumber) {
        checkNotContainZero(inputNumber);
        checkLength(inputNumber.size());
        checkDuplicate(inputNumber);
    }

    private void checkDuplicate(List<Integer> inputNumber) {
        long distinctCount = inputNumber.stream().distinct().count();

        if (distinctCount != inputNumber.size()) {
            throw new IllegalArgumentException(NOT_DUPLICATE.getMessage());
        }
    }

    private void checkLength(int length) {
        if (length != GameNumberSet.NUMBER_LENGTH) {
            throw new IllegalArgumentException(CHECK_NUMBERS_LENGTH.getMessage());
        }
    }

    private void checkNotContainZero(List<Integer> inputNumber) {
        if (inputNumber.contains(0)) {
            throw new IllegalArgumentException(NOT_ZERO.getMessage());
        }
    }

    public Integer getNumberAtIndex(int index) {
        return inputNumber.get(index);
    }
}
