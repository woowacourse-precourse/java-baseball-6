package baseball.model.domain;

import baseball.model.service.ComputerNumbersGenerator;
import java.util.List;

public class Computer {
    private List<Integer> computerNumbers;
    private ComputerNumbersGenerator computerNumbersGenerator;

    public Computer(ComputerNumbersGenerator computerNumbersGenerator) {
        this.computerNumbersGenerator = computerNumbersGenerator;
        computerNumbers = computerNumbersGenerator.generateComputerNumbers();
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}
