package baseball.domain;

import java.util.List;

public class GameNumbers {
    private static final int LENGTH = 3;

    private List<GameNumber> gameNumbers;

    public GameNumbers(int gameNumbers) {
        validate(gameNumbers);
    }

    private void validate(int gameNumbers) {
        validateIsNegative(gameNumbers);
        validateLength(gameNumbers);
    }

    private void validateIsNegative(int gameNumbers) {
        if (gameNumbers < 0) {
            throw new IllegalArgumentException("Error : 게임 숫자는 음수일 수 없습니다.");
        }
    }

    private void validateLength(int gameNumbers) {
        if (Integer.toString(gameNumbers).length() != LENGTH) {
            throw new IllegalArgumentException(String.format("Error : 게임 숫자는 %d 자리 수이어야 합니다.", LENGTH));
        }
    }
}
