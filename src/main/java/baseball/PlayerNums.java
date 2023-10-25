package baseball;

import java.util.List;

public class PlayerNums {
    int LENGTH = 3;
    List<Integer> playerNums;

    PlayerNums(List<Integer> playerNums) {
        validateNums(playerNums);
        this.playerNums = playerNums;
    }

    private void validateNums(List<Integer> playerNums) {
        checkOverlapping(playerNums);
        checkLength(playerNums);
        checkWord(playerNums);
    }

    private void checkOverlapping(List<Integer> playerNums) {
        if (playerNums.size() != playerNums.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 값이 있습니다.");
        }
    }

    private void checkLength(List<Integer> playerNums) {
        if (playerNums.size() != LENGTH) {
            throw new IllegalArgumentException("입력 값의 길이가 올바르지 않습니다.");
        }
    }

    private void checkWord(List<Integer> playerNums) {
        if (playerNums.stream().anyMatch(num -> num < 1 || num > 9)) {
            throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
        }
    }

    public List<Integer> getNums() {
        return playerNums;
    }
}
