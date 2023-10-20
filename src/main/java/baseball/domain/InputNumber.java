package baseball.domain;

import java.util.List;

public class InputNumber {

    private final List<Integer> inputNumber;

    public InputNumber(List<Integer> inputNumber) {
        this.inputNumber = inputNumber;
    }

    public Integer getNumberAtIndex(int index) {
        return inputNumber.get(index);
    }
}
