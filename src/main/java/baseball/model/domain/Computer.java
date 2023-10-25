package baseball.model.domain;

import baseball.model.service.Generator;
import java.util.List;

public class Computer {
    private final List<Integer> computerNumbers;

    private Computer(Generator generator) {
        computerNumbers = generator.generateComputerNumbers();
    }

    public static Computer from(Generator generator) {
        return new Computer(generator);
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}
