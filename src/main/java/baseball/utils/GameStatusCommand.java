package baseball.utils;

import java.util.Arrays;

public enum GameStatusCommand {

    RESTART(1), QUIT(2);

    private final int number;

    GameStatusCommand(int number) {
        this.number = number;
    }

    public static GameStatusCommand of(int number) {
        return Arrays.stream(GameStatusCommand.values())
                .filter(command -> command.number == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("1 또는 2만 입력 가능합니다."));
    }

    public int getNumber() {
        return number;
    }
}