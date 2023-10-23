package baseball;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

enum GameCommand {

    RESTART(1), END(2);

    private static final Map<Integer, GameCommand> commandClassifier = new HashMap<>();
    private static final String INVALID_COMMAND_MESSAGE = "유효한 커맨드를 입력해주세요.";

    private final int value;

    static {
        commandClassifier.put(RESTART.value, RESTART);
        commandClassifier.put(END.value, END);
    }

    GameCommand(int value) {
        this.value = value;
    }

    public static GameCommand from(int value) {
        return Optional.ofNullable(commandClassifier.get(value))
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COMMAND_MESSAGE));
    }

    public int getValue() {
        return value;
    }

    public boolean isRestart() {
        return this.equals(RESTART);
    }
}
