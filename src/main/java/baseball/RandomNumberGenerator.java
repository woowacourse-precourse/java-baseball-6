package baseball;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    private final RandomService randomService;

    public RandomNumberGenerator(RandomService randomService) {
        this.randomService = randomService;
    }

    public List<Integer> createRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (isSizeNotOver(numbers)) {
            addNumberIfNotDuplicate(numbers);
        }

        return numbers;
    }

    private boolean isSizeNotOver(List<Integer> numbers) {
        return numbers.size() < 3;
    }

    private void addNumberIfNotDuplicate(List<Integer> numbers) {
        int number = randomService.pickNumberInRange(1, 9);
        if (isNotDuplicate(numbers, number)) {
            numbers.add(number);
        }
    }

    private boolean isNotDuplicate(List<Integer> numbers, int number) {
        return !numbers.contains(number);
    }
}
