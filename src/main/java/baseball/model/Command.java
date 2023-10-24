package baseball.model;

import baseball.constant.ErrorMessage;

import java.util.Arrays;

public enum Command {

    RESTART("1"),
    QUIT("2");

    final String value;

    Command(String value) {
        this.value = value;
    }

    public static Command fromValue(String value) {
        return Arrays.stream(Command.values())
                .filter(command -> command.value.equals(value))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.ERROR + ErrorMessage.INVALID_COMMAND));
    }

    public static Boolean isRestart(Command command) {
        if (Command.QUIT.equals(command)) {
            return false;
        }
        if (Command.RESTART.equals(command)) {
            return true;
        }
        throw new IllegalArgumentException(ErrorMessage.ERROR + ErrorMessage.INVALID_COMMAND);
    }

    @Override
    public String toString() {
        return this.value;
    }
}
