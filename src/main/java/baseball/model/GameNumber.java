package baseball.model;

import baseball.constant.ErrorMessage;
import baseball.constant.Number;
import baseball.util.Converter;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class GameNumber {

    private final List<Integer> gameNumber;

    public GameNumber(List<Integer> gameNumber) {
        validateLength(gameNumber);
        validateRange(gameNumber);
        this.gameNumber = gameNumber;
    }

    public GameNumber(String value) {
        validateType(value);
        List<Integer> gameNumber = Converter.convertList(value);
        validateLength(gameNumber);
        validateRange(gameNumber);
        this.gameNumber = gameNumber;
    }

    public static GameNumber of(List<Integer> number) {
        return new GameNumber(number);
    }

    public int size() {
        return gameNumber.size();
    }

    public Integer get(int index) {
        return gameNumber.get(index);
    }

    public boolean contains(Object target) {
        return gameNumber.contains((Integer) target);
    }

    @Override
    public boolean equals(Object target) {
        if (this == target) {
            return true;
        }
        if (!(target instanceof GameNumber number)) {
            return false;
        }
        return gameNumber.equals(number.gameNumber);
    }

    @Override
    public String toString() {
        return gameNumber.toString();
    }

    private void validateType(String value) {
        try {
            Arrays.stream(value.split(""))
                    .forEach(Integer::parseInt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_GAME_NUMBER);
        }
    }

    private void validateLength(List<Integer> gameNumber) {
        if (!Number.SIZE.equals(Set.copyOf(gameNumber).size())
                || !Number.SIZE.equals(gameNumber.size())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_GAME_NUMBER);
        }
    }

    private void validateRange(List<Integer> gameNumber) {
        if (!gameNumber.stream().allMatch(number -> Number.MIN <= number
                && number <= Number.MAX)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_GAME_NUMBER);
        }
    }
}
