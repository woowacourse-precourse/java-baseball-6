package baseball.domain.config;

public enum GameCommand {
    RESTART(1),
    QUIT(2);

    private static final String GAME_COMMAND_ERROR_MESSAGE = "1 또는 2를 입력해야 합니다.";
    private final int option;

    GameCommand(int option) {
        this.option = option;
    }

    public static GameCommand from(int input) {
        for (GameCommand command : values()) {
            if (command.option == input) {
                return command;
            }
        }
        throw new IllegalArgumentException(GAME_COMMAND_ERROR_MESSAGE);
    }
}
