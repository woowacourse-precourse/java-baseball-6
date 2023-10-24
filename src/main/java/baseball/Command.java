package baseball;

import java.util.Arrays;

enum Command {
    RETRY("1", true),
    EXIT("2", false)
    ;

    final String key;
    final boolean retry;

    Command(final String key, final boolean retry) {
        this.key = key;
        this.retry = retry;
    }

    static Command getCommand(final String input) {
        return Arrays.stream(Command.values())
                .filter(command -> command.key.equals(input))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
