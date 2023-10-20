package baseball.domain;

import java.util.HashSet;
import java.util.List;

public final class PlayerNumbers {
    private final List<Integer> numbers;

    public PlayerNumbers(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateDuplicate(List<Integer> numbers) {
        int distinctSize = new HashSet<>(numbers).size();

        if (numbers.size() != distinctSize) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != AnswerNumbers.NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
