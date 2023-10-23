package baseball.computer;

import baseball.computer.generator.RandomNumberGenerator;
import java.util.List;

public class Computer {
    public List<Integer> generateNumbers() {
        return new RandomNumberGenerator().getNumbers();
    }
}

