package baseball.domain;

import baseball.exception.DuplicateException;
import baseball.exception.ErrorMessage;
import baseball.exception.InvalidSizeException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public Result calculateResult(Balls balls) {
        int strikeCount = Math.toIntExact(IntStream.range(0, balls.numbers.size())
                .filter(idx -> isSameIndex(idx, balls))
                .count());

        int ballCount = Math.toIntExact(IntStream.range(0, balls.numbers.size())
                .filter(idx -> hasBall(balls.numbers.get(idx)) && !isSameIndex(idx, balls))
                .count());

        return Result.createFrom(strikeCount, ballCount);
    }

    private boolean hasBall(Ball ball) {
        return this.numbers.contains(ball);
    }

    private boolean isSameIndex(int index, Balls balls) {
        return this.numbers.get(index).equals(balls.numbers.get(index));
    }
}
