package baseball.model;

import java.util.List;

public class ComputerNumber {
    private final List<Integer> computerNumber;

    public ComputerNumber(List<Integer> computerNumber) {
        this.computerNumber = computerNumber;
    }

    public void addDigit(Integer digit) {
        validateComputerNumber(digit);
        this.computerNumber.add(digit);
    }

    public List<Integer> getComputerNumber() {
        return this.computerNumber;
    }

    private void validateComputerNumber(Integer digit) {
        if (!this.computerNumber.contains(digit)) {
            this.computerNumber.add(digit);
        }
    }
}
