package baseball.config;

public enum GameCommand {
    RESTART(1),
    QUIT(2);

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
        throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
    }
}
