package baseball;

public enum GameCommand {
    RETRY(1),
    QUIT(2);

    private final Integer command;

    GameCommand(Integer command) {
        this.command = command;
    }
}
