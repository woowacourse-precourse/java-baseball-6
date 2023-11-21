package baseball.domain;

import baseball.exception.DuplicateException;
import baseball.exception.ErrorMessage;
import baseball.exception.InvalidSizeException;
import java.util.List;
import java.util.stream.Collectors;

public class Balls {
    private final List<Ball> numbers;

    private Balls(List<Ball> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    public static Balls createOf(List<Integer> userNumbers) {
        List<Ball> numbers = userNumbers.stream()
                .map(Ball::createOf)
                .collect(Collectors.toList());

        return new Balls(numbers);
    }

    private void validateDuplication(List<Ball> userBalls) {
        if (userBalls.size() != userBalls.stream().distinct().count()) {
            throw DuplicateException.of(ErrorMessage.DUPLICATED_VALUE);
        }
    }

    private void validateSize(List<Ball> userBalls) {
        if (userBalls.size() != 3) {
            throw InvalidSizeException.of(ErrorMessage.NOT_REQUIRED_SIZE);
        }
    }
}
