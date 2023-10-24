package baseball.model;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BaseBallNumbers {

    private static final int NUMBER_SIZE = 3;
    private static final int ZERO_INDEX = 0;
    private final List<BaseBallNumber> numbers;

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
            throw new IllegalArgumentException(ExceptionMessage.BASEBALL_NUMBER_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private boolean hasOverSize(List<BaseBallNumber> numbers) {
        return numbers.size() != NUMBER_SIZE;
    }

    private void validateDuplicate(List<BaseBallNumber> numbers) {
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.BASEBALL_NUMBER_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private boolean hasDuplicate(List<BaseBallNumber> numbers) {
        return numbers
                .stream()
                .distinct()
                .count() != NUMBER_SIZE;
    }

    public static BaseBallNumbers from(List<Integer> playerNumbers) {
        return playerNumbers.stream()
                .map(BaseBallNumber::from)
                .collect(collectingAndThen(toList(), BaseBallNumbers::new));
    }

    public static BaseBallNumbers createRandomNumbers(NumberGenerator numberGenerator) {
        return Stream.generate(() -> BaseBallNumber.createRandomNumber(numberGenerator))
                .distinct()
                .limit(NUMBER_SIZE)
                .collect(collectingAndThen(toList(), BaseBallNumbers::new));
    }

    public BaseBallGameResult evaluateGameResult(BaseBallNumbers playerNumbers) {
        int strikeCount = calculateStrikeCount(playerNumbers);
        int ballCount = calculateBallCount(playerNumbers, strikeCount);

        return BaseBallGameResult.of(strikeCount, ballCount);
    }

    private int calculateStrikeCount(BaseBallNumbers playerNumbers) {
        long strikeCount = IntStream.range(ZERO_INDEX, NUMBER_SIZE)
                .filter(index -> hasMatchingNumberAt(playerNumbers, index))
                .count();

        return (int) strikeCount;
    }

    private boolean hasMatchingNumberAt(BaseBallNumbers playerNumbers, int index) {
        BaseBallNumber computerBaseBallNumber = getNumberAt(index);
        BaseBallNumber playerBaseBallNumber = playerNumbers.getNumberAt(index);
        return computerBaseBallNumber.equals(playerBaseBallNumber);
    }

    private BaseBallNumber getNumberAt(int index) {
        return numbers.get(index);
    }

    private int calculateBallCount(BaseBallNumbers playerNumbers, int strikeCount) {
        int matchingNumberCount = countNumbersContainedIn(playerNumbers);
        return matchingNumberCount - strikeCount;
    }

    private int countNumbersContainedIn(BaseBallNumbers playerNumbers) {
        return (int) numbers.stream()
                .filter(playerNumbers::contains)
                .count();
    }

    private boolean contains(BaseBallNumber number) {
        return numbers.contains(number);
    }

}
