package baseball.config;

import java.util.Arrays;

public enum GameCommand {

    RESTART(1),
    QUIT(2);

    private final int number;

    GameCommand(int number) {
        this.number = number;
    }

    public static GameCommand from(int input) {
        return Arrays.stream(GameCommand.values())
                .filter(gameCommand -> gameCommand.number == input)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int getNumber() {
        return number;
    }
}
