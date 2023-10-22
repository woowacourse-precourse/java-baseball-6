package baseball.domain;

import baseball.util.Err;

public enum GameStatus {
    RESTART("1"),
    EXIT("2");

    private final String is;

    GameStatus(String is) {
        this.is = is;
    }

    public static GameStatus of(String input) {

        if (RESTART.is.equals(input)) {
            return RESTART;
        }
        if (EXIT.is.equals(input)) {
            return EXIT;
        }
        throw new IllegalArgumentException(Err.ERROR_GAME_ACTION_INPUT_MESSAGE.getMessage());
    }
}
