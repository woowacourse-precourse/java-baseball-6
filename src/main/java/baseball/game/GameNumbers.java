package baseball.game;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameNumbers {
    private static final int GAME_NUMBER_SIZE = 3;
    private static final int MIN_GAME_NUMBER_RANGE = 1;
    private static final int MAX_GAME_NUMBER_RANGE = 9;
    private List<Integer> numbers;

    public GameNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public int getNumberByIndex(int index) {
        return numbers.get(index);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    public int size() {
        return numbers.size();
    }

    private static void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumberRange(numbers);
        validateIsContainDuplicateNumber(numbers);
    }

    private static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != GAME_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_GAME_NUMBER_RANGE || number > MAX_GAME_NUMBER_RANGE) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void validateIsContainDuplicateNumber(List<Integer> numbers) {
        Set<Integer> target = new HashSet<>(numbers);

        if (target.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }
}
