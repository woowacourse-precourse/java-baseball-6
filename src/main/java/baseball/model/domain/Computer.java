package baseball.model.domain;

import baseball.model.service.ComputerNumbersGenerator;
import baseball.model.service.ComputerNumbersGeneratorImp;
import java.util.List;

public class Computer {
    private List<Integer> computerNumbers;

    public Computer() {
        ComputerNumbersGenerator computerNumbersGenerator = new ComputerNumbersGeneratorImp();
        computerNumbers = computerNumbersGenerator.generateComputerNumbers();
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}
