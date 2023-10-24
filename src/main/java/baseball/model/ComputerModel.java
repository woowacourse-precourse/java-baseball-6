package baseball.model;

import java.util.List;

public class ComputerModel {

    private final List<Integer> splitDigitsFromRandomNumber;

    public ComputerModel(List<Integer> splitDigitsFromRandomNumber) {
        this.splitDigitsFromRandomNumber = splitDigitsFromRandomNumber;
    }

    public Integer getSplitDigitFromRandomNumber(int trackIdx) {
        return splitDigitsFromRandomNumber.get(trackIdx);
    }

    public boolean hasContainNumber(int digit) {
        return splitDigitsFromRandomNumber.contains(digit);
    }
}
