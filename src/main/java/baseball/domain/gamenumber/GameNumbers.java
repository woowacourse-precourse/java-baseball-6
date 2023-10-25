package baseball.domain.gamenumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class GameNumbers {
    public static final int LENGTH = 3;

    private final List<GameNumber> gameNumbers;

    public GameNumbers(String gameNumbers) {
        GameNumbersValidator.validate(gameNumbers);

        this.gameNumbers = Arrays.stream(gameNumbers.split(""))
                .map(Integer::parseInt)
                .map(GameNumber::from)
                .collect(Collectors.toList());
    }

    public int countStrike(GameNumbers otherGameNumbers) {
        return (int) IntStream.range(0, LENGTH)
                .filter(index -> isSameNumberSameIndex(otherGameNumbers, index))
                .count();
    }

    private boolean isSameNumberSameIndex(GameNumbers otherGameNumbers, int index) {
        return getGameNumber(index).equals(otherGameNumbers.getGameNumber(index));
    }

    private GameNumber getGameNumber(int index) {
        return gameNumbers.get(index);
    }

    public int countBall(GameNumbers otherGameNumbers) {
        return (int) IntStream.range(0, LENGTH)
                .filter(index -> isSameNumberDifferentIndex(otherGameNumbers, index))
                .count();
    }

    private boolean isSameNumberDifferentIndex(GameNumbers otherGameNumbers, int index) {
        return contains(otherGameNumbers.getGameNumber(index)) && !isSameNumberSameIndex(otherGameNumbers, index);
    }

    private boolean contains(GameNumber gameNumber) {
        return gameNumbers.contains(gameNumber);
    }
}
