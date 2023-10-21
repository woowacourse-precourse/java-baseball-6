package baseball.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public enum GameCommand {
    RESTART(1), END(2);

    private final int command;
    private static final String INVALID_GAME_STATUS_MESSAGE = "1 또는 2를 입력해주세요";
    private static final Map<Integer, GameCommand> cache;

    static {
        cache = Arrays.stream(GameCommand.values())
                .collect(Collectors.toMap((gameCommand -> gameCommand.command), gameCommand -> gameCommand));
    }

    GameCommand(int command) {
        this.command = command;
    }

    public static GameCommand from(int command) {
        return Optional.ofNullable(cache.get(command))
                .orElseThrow(() -> new IllegalArgumentException(INVALID_GAME_STATUS_MESSAGE));
    }

    public boolean isEnd() {
        return this == END;
    }
}
