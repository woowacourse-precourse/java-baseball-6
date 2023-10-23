package baseball.domain.player;

import baseball.domain.player.number.Number;

import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private static final int BASEBALL_NUMBERS_LIMIT_SIZE = 3;
    private List<Number> numbers;

    private Player(List<Number> numbers) {
        this.numbers = numbers;
    }
    public static Player createByIntegerNumbers(List<Integer> inputNumbers) {
        checkInputSize(inputNumbers.size());
        List<Number> numbers = inputNumbers.stream()
                .map(Number::from)
                .collect(Collectors.toList());
        return new Player(numbers);
    }

    private static void checkInputSize(int size) {
        if (size > BASEBALL_NUMBERS_LIMIT_SIZE) {
            throw new IllegalArgumentException("3개 이상의 공이 입력될 수 없습니다.");
        }
    }
}
