package baseball.model;

import java.util.List;

public class ComputerNumber {

    private final List<Integer> computerNumber;

    public ComputerNumber(List<Integer> computerNumber) {
        validate();
        this.computerNumber = computerNumber;
    }

    private void validate() {

    }
}
