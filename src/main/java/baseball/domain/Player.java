package baseball.domain;

import baseball.util.Sentence;

import java.util.List;

public class Player {
    private final List<Integer> numbers;

    private Player(List<Integer> numbers) {
        validateThreeSize(numbers);
        validateDuplicationNumbers(numbers);
        this.numbers = numbers;
    }

    public static Player of(List<Integer> numbers) {
        return new Player(numbers);
    }

    private void validateThreeSize(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException(Sentence.ERROR_NOT_THREE_SIZE_MESSAGE.getMessage());
        }
    }

    private void validateDuplicationNumbers(List<Integer> numbers) {
        long duplicationCount = numbers.stream()
                .distinct()
                .count();

        if (duplicationCount != numbers.size()) {
            throw new IllegalArgumentException(Sentence.ERROR_NUMBERS_DUPLICATION_MESSAGE.getMessage());
        }
    }
}
