package baseball.model;

import java.util.List;

public class Computer {
    private Numbers savedNumbers;

    public void saveNumbers(List<Integer> generatedNumbers) {
        savedNumbers.from(generatedNumbers);
    }
}
