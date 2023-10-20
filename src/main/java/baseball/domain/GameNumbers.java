package baseball.domain;

import java.util.List;

public class GameNumbers {
    private static final int LENGTH = 3;
    private static final String VALID_NUMBER_LENGTH = String.format("^\\d{%d}$", LENGTH);

    private List<GameNumber> gameNumbers;

    public GameNumbers(String gameNumbers) {
        validate(gameNumbers);
    }

    private void validate(String gameNumbers) {
        validateNumberLength(gameNumbers);
    }

    private void validateNumberLength(String gameNumbers) {
        if (!gameNumbers.matches(VALID_NUMBER_LENGTH)) {
            throw new IllegalArgumentException("Error : 게임 숫자는 3개의 수로 이루어져야 합니다.");
        }
    }
}
