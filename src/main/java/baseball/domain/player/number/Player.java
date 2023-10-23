package baseball.domain.player.number;

import baseball.exception.player.InputSizeException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Player {
    private static final int BASEBALL_NUMBERS_LIMIT_SIZE = 3;
    private List<Number> numbers;

    private Player(List<Number> numbers) {
        this.numbers = numbers;
    }
    public static Player createByIntegerNumbers(List<Integer> inputNumbers) {
        checkInputSize(inputNumbers.size());
        checkForDuplicateNumbers(inputNumbers);
        List<Number> numbers = inputNumbers.stream()
                .map(Number::from)
                .collect(Collectors.toList());
        return new Player(numbers);
    }

    private static void checkInputSize(int size) {
        if (size > BASEBALL_NUMBERS_LIMIT_SIZE) {
            throw new InputSizeException();
        }
    }
    private static void checkForDuplicateNumbers(List<Integer> inputNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(inputNumbers);
        if (uniqueNumbers.size() != inputNumbers.size()) {
            throw new IllegalArgumentException("중복된 숫자는 입력될 수 없습니다.");
        }
    }
}
