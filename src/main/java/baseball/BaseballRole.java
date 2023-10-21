package baseball;

public enum BaseballRole {
    MAX_BASEBALL_NUMBER_SIZE(3),
    THREE_STRIKE(3),
    MIN_BASEBALL_NUMBER(1),
    MAX_BASEBALL_NUMBER(9),
    GAME_RESTART(1),
    GAME_EXIT(2);

    private final int value;

    BaseballRole(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static boolean isGameExit(int value){
        validateRestartMessage(value);
        return value == GAME_EXIT.value;
    }

    private static void validateRestartMessage(int value){
        if(value != GAME_RESTART.value && value != GAME_EXIT.value){
            throw new IllegalArgumentException(getRestartErrorMessage());
        }
    }

    private static String getRestartErrorMessage() {
        return String.format(ErrorMessage.INPUT_RESTART_ERROR.getMessage(), GAME_RESTART.value, GAME_RESTART.value);
    }
}
