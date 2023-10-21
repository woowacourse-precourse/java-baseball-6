package baseball.domain;

import java.util.Arrays;
import java.util.stream.Stream;

public enum GameHandlerCommand {

    RESTART("1"),
    STOP("2")
    ;

    private String command;

    GameHandlerCommand(String command) {
        this.command = command;
    }

    public static GameHandlerCommand findCommand(String command) {
        return Stream.of(GameHandlerCommand.values())
                .filter(value -> value.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재 하지 않는 커맨드입니다"));
    }
}
