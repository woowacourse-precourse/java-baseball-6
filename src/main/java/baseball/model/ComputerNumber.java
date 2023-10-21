package baseball.model;

import java.util.List;

public class ComputerNumber {

    private final List<Integer> computerNumber;

    public ComputerNumber(List<Integer> computerNumber) {
        validateSize(computerNumber);
        this.computerNumber = computerNumber;
    }

    private void validateSize(List<Integer> computerNumber) {
        if (computerNumber.size() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
