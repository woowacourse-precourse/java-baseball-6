package baseball.domain;

import baseball.service.RandomService;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    public static final int RANDOM_NUMBER_SIZE = 3;
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
        return numbers.size() < RANDOM_NUMBER_SIZE;
    }

    private void addNumberIfNotDuplicate(List<Integer> numbers) {
        int number = randomService.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        if (isNotDuplicate(numbers, number)) {
            numbers.add(number);
        }
    }

    private boolean isNotDuplicate(List<Integer> numbers, int number) {
        return !numbers.contains(number);
    }
}
