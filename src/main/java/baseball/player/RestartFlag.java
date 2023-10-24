package baseball.player;

public class RestartFlag {
    private static final String RESTART_FLAG = "1";
    private static final String EXIT_FLAG = "2";

    private final boolean flag;

    public RestartFlag(String playerInput) {
        checkNullInput(playerInput);
        checkInvalidInput(playerInput);
        this.flag = toBoolean(playerInput);
    }

    private void checkNullInput(String playerInput) {
        if (playerInput == null) {
            throw new IllegalArgumentException();
        }
    }

    private void checkInvalidInput(String playerInput) {
        if (!playerInput.equals(RESTART_FLAG) && !playerInput.equals(EXIT_FLAG)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean toBoolean(String playerInput) {
        return playerInput.equals(RESTART_FLAG);
    }

    public boolean toBoolean() {
        return flag;
    }
}
