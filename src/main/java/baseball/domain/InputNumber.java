package baseball.domain;

import java.util.List;

public class InputNumber {

    private final List<Integer> inputNumber;

    public InputNumber(List<Integer> inputNumber) {
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
            throw new IllegalArgumentException("");
        }
    }

    private void checkLength(int length) {
        if (length > 3) {
            throw new IllegalArgumentException("");
        }
    }

    private void checkNotContainZero(List<Integer> inputNumber) {
        if (inputNumber.contains(0)) {
            throw new IllegalArgumentException("");
        }
    }

    public Integer getNumberAtIndex(int index) {
        return inputNumber.get(index);
    }
}
