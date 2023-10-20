package baseball.model;

import baseball.util.Converter;

import java.util.List;
import java.util.Set;

import static baseball.constant.NumberConstants.MAX_NUMBER;
import static baseball.constant.NumberConstants.MIN_NUMBER;
import static baseball.constant.NumberConstants.NUMBER_SIZE;

public class GameNumber {

    private final List<Integer> gameNumber;

    public GameNumber(List<Integer> gameNumber) {
        validateLength(gameNumber);
        validateRange(gameNumber);
        this.gameNumber = gameNumber;
    }

    public GameNumber(String value) {
        validateValue(value);
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

    public boolean contains(Object o) {
        return gameNumber.contains((Integer) o);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GameNumber number)) {
            return false;
        }
        return gameNumber.equals(number.gameNumber);
    }

    @Override
    public String toString() {
        return gameNumber.toString();
    }

    private void validateValue(String value) {
        try {
            if (Integer.parseInt(value) < 0) {
                throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
        }
    }

    private void validateLength(List<Integer> gameNumber) {
        if (!NUMBER_SIZE.getValue().equals(Set.copyOf(gameNumber).size())
                || !NUMBER_SIZE.getValue().equals(gameNumber.size())) {
            throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
        }
    }

    private void validateRange(List<Integer> gameNumber) {
        if (!gameNumber.stream().allMatch(number -> MIN_NUMBER.getValue() <= number
                && number <= MAX_NUMBER.getValue())) {
            throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
        }
    }
}
