package baseball.model;

import baseball.constant.ErrorMessage;
import baseball.constant.Number;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class GameNumbers {

    private final List<SingleNumber> gameNumber;

    public GameNumbers(List<Integer> value) {
        List<SingleNumber> gameNumber = value.stream().map(SingleNumber::new).toList();
        validate(gameNumber);
        this.gameNumber = gameNumber;
    }

    public GameNumbers(String value) {
        List<SingleNumber> gameNumber = Arrays.stream(value.split("")).map(SingleNumber::new).toList();
        validate(gameNumber);
        this.gameNumber = gameNumber;
    }

    private void validate(List<SingleNumber> target) {
        validateDuplicate(target);
        validateSize(target);
    }

    public static GameNumbers of(String value) {
        return new GameNumbers(value);
    }

    public int size() {
        return gameNumber.size();
    }

    public SingleNumber get(int index) {
        return gameNumber.get(index);
    }

    public boolean contains(Object target) {
        return gameNumber.contains((SingleNumber) target);
    }

    @Override
    public boolean equals(Object target) {
        if (this == target) {
            return true;
        }
        if (!(target instanceof GameNumbers number)) {
            return false;
        }
        return gameNumber.equals(number.gameNumber);
    }

    @Override
    public String toString() {
        return gameNumber.toString();
    }

    private void validateSize(List<SingleNumber> gameNumber) {
        if (!Number.SIZE.equals(gameNumber.size())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_GAME_NUMBER);
        }
    }

    private void validateDuplicate(List<SingleNumber> gameNumber) {
        if (gameNumber.size() != Set.copyOf(gameNumber).size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_GAME_NUMBER);
        }
    }
}
