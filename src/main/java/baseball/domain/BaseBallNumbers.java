package baseball.domain;

import static baseball.domain.ExceptionMessage.BASEBALL_NUMBER_DUPLICATE_EXCEPTION_MESSAGE;
import static baseball.domain.ExceptionMessage.BASEBALL_NUMBER_SIZE_EXCEPTION_MESSAGE;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.List;

public class BaseBallNumbers {

    private static final int NUMBER_SIZE = 3;
    private final List<BaseBallNumber> playerNumbers;

    public static BaseBallNumbers from(List<Integer> playerNumbers) {
        return playerNumbers.stream()
                .map(BaseBallNumber::from)
                .collect(collectingAndThen(toList(), BaseBallNumbers::new));
    }

    private BaseBallNumbers(List<BaseBallNumber> playerNumbers) {
        validate(playerNumbers);
        this.playerNumbers = playerNumbers;
    }

    private void validate(List<BaseBallNumber> playerNumbers) {
        validateSize(playerNumbers);
        validateDuplicate(playerNumbers);
    }

    private void validateSize(List<BaseBallNumber> playerNumbers) {
        if (hasOverSize(playerNumbers)) {
            throw new IllegalArgumentException(BASEBALL_NUMBER_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private void validateDuplicate(List<BaseBallNumber> playerNumbers) {
        if (hasDuplicate(playerNumbers)) {
            throw new IllegalArgumentException(BASEBALL_NUMBER_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private boolean hasOverSize(List<BaseBallNumber> playerNumbers) {
        return playerNumbers.size() != NUMBER_SIZE;
    }

    private boolean hasDuplicate(List<BaseBallNumber> playerNumbers) {
        return playerNumbers
                .stream()
                .distinct()
                .count() != NUMBER_SIZE;
    }

}
