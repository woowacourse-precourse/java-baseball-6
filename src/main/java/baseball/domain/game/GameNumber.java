package baseball.domain.game;

import baseball.util.Err;

public record GameNumber(int gameNumber) {
    private static final int MIN_GAME_NUMBER = 1;
    private static final int MAX_GAME_NUMBER = 9;

    public GameNumber {
        validateGameNumber(gameNumber);
    }

    private void validateGameNumber(int gameNumber) {
        if (gameNumber < MIN_GAME_NUMBER || gameNumber > MAX_GAME_NUMBER) {
            throw new IllegalArgumentException(Err.OUT_OF_RANGE_NUMBERS.getMessage());
        }
    }
}
