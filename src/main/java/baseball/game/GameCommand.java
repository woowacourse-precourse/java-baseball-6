package baseball.game;

public enum GameCommand {
    RESTART(1),
    END(2);

    private final int commandValue;

    GameCommand(int commandValue) {
        this.commandValue = commandValue;
    }

    public int getCommandValue() {
        return this.commandValue;
    }
}
