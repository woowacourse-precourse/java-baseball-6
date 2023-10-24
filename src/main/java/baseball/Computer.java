package baseball;

import java.util.List;

public class Computer {

    private List<Integer> numbers;

    public void generateNumbers() {
        RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator();
        this.numbers = randomNumbersGenerator.generateNumbers();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
