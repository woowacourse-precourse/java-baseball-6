package baseball;

import input.InputErrorMessage;

public enum GameStatus {

    START("1"), GAME_OVER("2");

    private final String value;

    GameStatus(String value) {
        this.value = value;
    }

    public static GameStatus from(String value) {
        validate(value);
        if (isStart(value)) {
            return START;
        }
        return GAME_OVER;
    }

    private static void validate(String value) {
        if (!(isStart(value) || isGameOver(value))) {
            throw new IllegalArgumentException(InputErrorMessage.GAME_STATUS);
        }
    }

    private static boolean isStart(String value) {
        return value.equals(START.value);
    }

    private static boolean isGameOver(String value) {
        return value.equals(GAME_OVER.value);
    }

    @Override
    public String toString() {
        return value;
    }
}
