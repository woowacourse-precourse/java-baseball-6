package baseball.model;

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
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public String toString() {
        return this.value;
    }
}
