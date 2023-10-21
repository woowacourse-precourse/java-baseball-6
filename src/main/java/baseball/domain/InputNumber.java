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
            throw new IllegalArgumentException("숫자의 중복은 허용되지 않습니다.");
        }
    }

    private void checkLength(int length) {
        if (length != 3) {
            throw new IllegalArgumentException("3자리 수의 숫자를 입력해주세요");
        }
    }

    private void checkNotContainZero(List<Integer> inputNumber) {
        if (inputNumber.contains(0)) {
            throw new IllegalArgumentException("0은 입력할 수 없습니다.");
        }
    }

    public Integer getNumberAtIndex(int index) {
        return inputNumber.get(index);
    }
}
