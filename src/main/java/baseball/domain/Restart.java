package baseball.domain;

import java.util.Arrays;

public enum Restart {
    RESTART(1),
    STOP(2);

    private final int gameCommand;

    Restart(int gameCommand) {
        this.gameCommand = gameCommand;
    }

    public static Restart from(int gameCommand) {
        return Arrays.stream(Restart.values())
                .filter(restart -> restart.gameCommand == gameCommand)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 재시작 커맨드가 아닙니다."));
    }
}
