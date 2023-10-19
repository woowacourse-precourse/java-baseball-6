package baseball.domain;

import java.util.List;

public class GameNumbers {
    private List<GameNumber> gameNumbers;

    public GameNumbers(int gameNumbers) {
        validate(gameNumbers);
    }

    private void validate(int gameNumbers) {
        validateIsNegative(gameNumbers);
    }

    private void validateIsNegative(int gameNumbers) {
        if (gameNumbers < 0) {
            throw new IllegalArgumentException("Error : 게임 숫자는 음수일 수 없습니다.");
        }
    }
}
