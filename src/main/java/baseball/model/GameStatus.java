package baseball.model;

public enum GameStatus {

    START("1"),
    STOP("2");

    private final String command;

    GameStatus(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}


