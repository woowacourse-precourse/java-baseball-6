package baseball.model;

import java.util.List;
import java.util.Set;

import static baseball.constant.NumberConstants.MAX_NUMBER;
import static baseball.constant.NumberConstants.MIN_NUMBER;
import static baseball.constant.NumberConstants.NUMBER_SIZE;

public class GameNumber {

    private final List<Integer> gameNumber;

    public GameNumber(List<Integer> gameNumber) {
        validLength(gameNumber);
        validRange(gameNumber);
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
    public String toString() {
        return gameNumber.toString();
    }

    private void validLength(List<Integer> gameNumber) {
        if (!NUMBER_SIZE.getValue().equals(Set.copyOf(gameNumber).size()) ||
                !NUMBER_SIZE.getValue().equals(gameNumber.size())) {
            throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
        }
    }

    private void validRange(List<Integer> gameNumber) {
        if (!gameNumber.stream().allMatch(number -> MIN_NUMBER.getValue() <= number
                && number <= MAX_NUMBER.getValue())) {
            throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
        }
    }
}
