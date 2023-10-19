package baseball.domain;

import static baseball.domain.ExceptionMessage.BASEBALL_NUMBER_DUPLICATE_EXCEPTION_MESSAGE;
import static baseball.domain.ExceptionMessage.BASEBALL_NUMBER_SIZE_EXCEPTION_MESSAGE;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

public class BaseBallNumbers {

    private static final int NUMBER_SIZE = 3;
    private final List<BaseBallNumber> numbers;

    public static BaseBallNumbers generateNumbers(List<Integer> playerNumbers) {
        return playerNumbers.stream()
                .map(BaseBallNumber::generateNumber)
                .collect(collectingAndThen(toList(), BaseBallNumbers::new));
    }

    private BaseBallNumbers(List<BaseBallNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<BaseBallNumber> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<BaseBallNumber> numbers) {
        if (hasOverSize(numbers)) {
            throw new IllegalArgumentException(BASEBALL_NUMBER_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private boolean hasOverSize(List<BaseBallNumber> numbers) {
        return numbers.size() != NUMBER_SIZE;
    }

    private void validateDuplicate(List<BaseBallNumber> numbers) {
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException(BASEBALL_NUMBER_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private boolean hasDuplicate(List<BaseBallNumber> numbers) {
        return numbers
                .stream()
                .distinct()
                .count() != NUMBER_SIZE;
    }

    public static BaseBallNumbers generateRandomNumbers(NumberGenerator numberGenerator) {
        return Stream.generate(() -> BaseBallNumber.generateRandomNumber(numberGenerator))
                .limit(NUMBER_SIZE)
                .collect(collectingAndThen(toList(), BaseBallNumbers::new));
    }

}
