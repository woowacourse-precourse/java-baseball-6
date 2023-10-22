package baseball.dto;

import static baseball.constants.Constants.ERROR_INVALID_COMMAND;

public enum GameCommand {
    RESTART("1"), END("2");
    private final String code;

    GameCommand(String code) {
        this.code = code;
    }

    public String getCommand() {
        return code;
    }

    public static GameCommand fromInputCommand(String input) {
        for (GameCommand command : values()) {
            if (command.getCommand().equals(input)) {
                return command;
            }
        }
        throw new IllegalArgumentException(ERROR_INVALID_COMMAND);
    }
}
