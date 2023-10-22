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
        return Command.RESTART.equals(command);
    }

    public static Boolean isQuit(Command command) {
        return Command.QUIT.equals(command);
    }

    @Override
    public String toString() {
        return this.value;
    }
}
