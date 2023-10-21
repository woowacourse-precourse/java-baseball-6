package baseball.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameNumbers {
    public static final int LENGTH = 3;
    private static final String VALID_NUMBER_LENGTH = String.format("^\\d{%d}$", LENGTH);

    private final List<GameNumber> gameNumbers;

    public GameNumbers(String gameNumbers) {
        validate(gameNumbers);

        this.gameNumbers = Arrays.stream(gameNumbers.split(""))
                .map(Integer::parseInt)
                .map(GameNumber::new)
                .collect(Collectors.toList());
    }

    private void validate(String gameNumbers) {
        validateNumberLength(gameNumbers);
        validateDuplication(gameNumbers);
    }

    private void validateNumberLength(String gameNumbers) {
        if (!gameNumbers.matches(VALID_NUMBER_LENGTH)) {
            throw new IllegalArgumentException("Error : 게임 숫자는 3개의 수로 이루어져야 합니다.");
        }
    }

    private void validateDuplication(String gameNumbers) {
        if (countDistinctNumbers(gameNumbers) != LENGTH) {
            throw new IllegalArgumentException("게임 숫자의 각 자리수는 중복될 수 없습니다.");
        }
    }

    private int countDistinctNumbers(String gameNumbers) {
        return (int) gameNumbers.chars()
                .distinct()
                .count();
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
