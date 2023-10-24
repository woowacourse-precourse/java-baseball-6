package baseball.model.domain;

import baseball.model.service.ComputerNumbersGenerator;
import java.util.List;

public class Computer {
    private final List<Integer> computerNumbers;

    private Computer(ComputerNumbersGenerator computerNumbersGenerator) {
        computerNumbers = computerNumbersGenerator.generateComputerNumbers();
    }

    public static Computer from(ComputerNumbersGenerator computerNumbersGenerator) {
        return new Computer(computerNumbersGenerator);
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}
