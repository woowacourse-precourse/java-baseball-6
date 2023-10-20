package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumbersGenerator {

    public static ComputerNumbers generate(NumberGenerator numberGenerator, int digitNumber) {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < digitNumber) {
            int generatedNumber = numberGenerator.generate();
            if (numbers.contains(generatedNumber)) {
                continue;
            }
            numbers.add(generatedNumber);
        }
        return new ComputerNumbers(numbers);
    }
}
