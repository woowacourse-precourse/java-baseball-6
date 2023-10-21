package baseball.domain;

public enum GameCommand {
    RESTART(1), END(2);

    private static final String INVALID_GAME_STATUS_MESSAGE = "1 또는 2를 입력해주세요";
    private final int command;

    GameCommand(int command) {
        this.command = command;
    }

    public static GameCommand from(int command) {
        for (GameCommand gameCommand : GameCommand.values()) {
            if (gameCommand.command == command) {
                return gameCommand;
            }
        }
        throw new IllegalArgumentException(INVALID_GAME_STATUS_MESSAGE);
    }

    public boolean isEnd() {
        return this == END;
    }
}
