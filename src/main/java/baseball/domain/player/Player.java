package baseball.domain.player;

import baseball.domain.computer.Computer;
import baseball.domain.number.Number;
import baseball.exception.player.DuplicateNumberException;
import baseball.exception.player.InputSizeException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Player {
    public static final int BASEBALL_NUMBERS_LIMIT_SIZE = 3;
    private List<Number> numbers;

    private Player(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Player createPlayerByIntegerNumbers(List<Integer> inputNumbers) {
        checkInputSize(inputNumbers.size());
        checkForDuplicateNumbers(inputNumbers);
        List<Number> players = integerToNumber(inputNumbers);
        return new Player(players);
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public static void checkInputSize(int size) {
        if (size > BASEBALL_NUMBERS_LIMIT_SIZE) {
            throw new InputSizeException();
        }
    }

    public static void checkForDuplicateNumbers(List<Integer> inputNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(inputNumbers);
        if (uniqueNumbers.size() != inputNumbers.size()) {
            throw new DuplicateNumberException();
        }
    }

    public static List<Number> integerToNumber(List<Integer> inputNumbers) {
        return inputNumbers.stream()
                .map(Number::from)
                .collect(Collectors.toList());
    }

    public int calculateStrikeCounts(Computer computer) {
        return (int) IntStream.range(0, BASEBALL_NUMBERS_LIMIT_SIZE)
                .filter(index -> isStrike(computer, index))
                .count();
    }

    private boolean isStrike(Computer computer, int idx) {
        return computer.getAnswerNumbers().get(idx).equals(this.numbers.get(idx));
    }

    public int calculateBallCounts(Computer computer) {
        return (int) IntStream.range(0, BASEBALL_NUMBERS_LIMIT_SIZE)
                .filter(index -> isBall(computer, index))
                .count();
    }

    private boolean isBall(Computer computer, int index) {
        if (isStrike(computer, index)) {
            return false;
        }
        return this.numbers.contains(computer.getAnswerNumbers().get(index));
    }
}
