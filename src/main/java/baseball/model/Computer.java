package baseball.model;

import baseball.utils.RandomNumbersGenerator;
import java.util.List;

public class Computer {

    public List<Integer> generateNumbers() {
        RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator();
        return randomNumbersGenerator.generateNumbers();
    }
}
