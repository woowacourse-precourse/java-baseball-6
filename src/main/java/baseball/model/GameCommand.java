package baseball.model;

public class GameCommand {

    private static final int RESTART_COMMAND = 1;
    private static final int END_COMMAND = 2;

    private final int command;

    public GameCommand(final int command) {
        validate(command);
        this.command = command;
    }

    private static void validate(final int command) {
        if (command != RESTART_COMMAND && command != END_COMMAND) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isEndSign() {
        return command == END_COMMAND;
    }
}

