package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class ComputerThreeNumbersGenerator {
    private final NumberGenerator numberGenerator;

    public ComputerThreeNumbersGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Computer createOtherThreeNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = numberGenerator.createRandomNumber();
            if (hasNotDuplicationNumber(numbers, randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return new Computer(numbers);
    }

    private boolean hasNotDuplicationNumber(List<Integer> numbers, int randomNumber) {
        for (Integer number : numbers) {
            if (number == randomNumber) {
                return false;
            }
        }
        return true;
    }
}
