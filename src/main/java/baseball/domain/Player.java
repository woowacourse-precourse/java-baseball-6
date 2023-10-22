package baseball.domain;

import baseball.util.Err;
import java.util.List;

public class Player {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int INPUT_SIZE = 3;
    private final List<Integer> numbers;

    private Player(List<Integer> numbers) {
        validateInputSize(numbers);
        validateInputRange(numbers);
        validateInputUniqueness(numbers);
        this.numbers = numbers;
    }

    public static Player of(List<Integer> numbers) {
        return new Player(numbers);
    }

    private void validateInputSize(List<Integer> numbers) {
        if (numbers.size() != INPUT_SIZE) {
            throw new IllegalArgumentException(Err.ERROR_NOT_THREE_SIZE_MESSAGE.getMessage());
        }
    }

    private void validateInputRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < START_INCLUSIVE || number > END_INCLUSIVE) {
                throw new IllegalArgumentException(Err.ERROR_INPUT_SCOPE_MESSAGE.getMessage());
            }
        }
    }

    private void validateInputUniqueness(List<Integer> numbers) {
        int uniqueCount = (int) numbers.stream()
                .distinct()
                .count();

        if (uniqueCount != numbers.size()) {
            throw new IllegalArgumentException(Err.ERROR_NUMBERS_DUPLICATION_MESSAGE.getMessage());
        }
    }

    public GameResult calculateAndGetGameResult(List<Integer> computer) {
        int ball = 0;
        int strike = 0;
        GameStatus gameStatus = GameStatus.ONGOING;

        for (Integer number : numbers) {
            int playerNumberPosition = numbers.indexOf(number);

            if (isSameAtPosition(computer, playerNumberPosition)) {
                strike += 1;
                continue;
            }

            if (isContainedAtPosition(computer, playerNumberPosition)) {
                ball += 1;
            }
        }

        if (strike == 3) {
            gameStatus = GameStatus.SUCCESS;
        }

        return new GameResult(ball, strike, gameStatus);
    }

    private boolean isSameAtPosition(List<Integer> computer, int index) {
        return numbers.get(index).equals(computer.get(index));
    }

    private boolean isContainedAtPosition(List<Integer> computer, int index) {
        return computer.contains(numbers.get(index));
    }
}
