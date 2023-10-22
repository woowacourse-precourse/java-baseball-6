package baseball.model;

import java.util.Arrays;

public enum Command {
    //TODO: 여기에 상수 선언 과연 맞을까

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
                .orElseThrow(IllegalArgumentException::new);
    }

    public static Boolean isRestart(Command command) {
        if (Command.QUIT.equals(command)) {
            return false;
        }
        if (Command.RESTART.equals(command)) {
            return true;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return this.value;
    }
}
