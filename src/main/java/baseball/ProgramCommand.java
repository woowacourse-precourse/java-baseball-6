package baseball;

public enum ProgramCommand {
    RETRY_NEW_GAME("1"),
    PROGRAM_FINISH("2");

    private final String value;

    ProgramCommand(String value) {
        this.value = value;
    }

    public static boolean isRetry(String command) {
        return command.equals(RETRY_NEW_GAME.value);
    }

    public static boolean isFinish(String command) {
        return command.equals(PROGRAM_FINISH.value);
    }

    public static void validate(String command) {
        if (!command.equals(RETRY_NEW_GAME.value) && !command.equals(PROGRAM_FINISH.value)) {
            throw new IllegalArgumentException();
        }
    }
}