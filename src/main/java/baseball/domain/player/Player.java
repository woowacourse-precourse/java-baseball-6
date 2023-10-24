package baseball.domain.player;

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

    private static void checkInputSize(int size) {
        if (size > BASEBALL_NUMBERS_LIMIT_SIZE) {
            throw new InputSizeException();
        }
    }
    private static void checkForDuplicateNumbers(List<Integer> inputNumbers) {
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

    public int calculateStrikeCounts(Player player) {
        return (int) IntStream.rangeClosed(0, 2)
                .filter(index -> isStrike(player, index))
                .count();
    }

    private boolean isStrike(Player player, int idx) {
        return player.numbers.get(idx).equals(this.numbers.get(idx));
    }

    public int calculateBallCounts(Player player) {
        return (int) IntStream.rangeClosed(0, 2)
                .filter(index -> isBall(player, index))
                .count();
    }

    private boolean isBall(Player player, int index) {
        if (isStrike(player, index)) {
            return false;
        }
        return this.numbers.contains(player.numbers.get(index));
    }
}
