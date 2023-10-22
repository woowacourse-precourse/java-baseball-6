package baseball.computer;

import java.util.List;

public class Computer {
    private final ComputerNumberGenerator numberGenerator;
    private List<Integer> numbers;

    public Computer() {
        this.numberGenerator = new ComputerNumberGenerator();
        this.numbers = generateAndStoreNumbers();
    }

    private List<Integer> generateAndStoreNumbers() {
        return numberGenerator.generateNumbers();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
