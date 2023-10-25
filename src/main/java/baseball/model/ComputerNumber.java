package baseball.model;

import baseball.ComputerNumberGenerator;

import java.util.List;

public class ComputerNumber {
    private final ComputerNumberGenerator numberGenerator;
    private List<Integer> computerNumber;

    public ComputerNumber(final ComputerNumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.computerNumber = makeComputerNumber();
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }

    private List<Integer> makeComputerNumber() {
        return computerNumber = numberGenerator.generateComputerNumber();
    }

}
