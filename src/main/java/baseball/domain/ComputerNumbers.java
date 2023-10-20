package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumbers {

    private final List<Integer> numbers = new ArrayList<>();

    public ComputerNumbers(NumberGenerator numberGenerator, int digitNumber) {
        while (numbers.size() < digitNumber) {
            int generatedNumber = numberGenerator.generate();
            if (this.numbers.contains(generatedNumber)) {
                continue;
            }
            numbers.add(generatedNumber);
        }
    }
}
