package baseball.common.contents;

public enum GameCommand {
    RESTART(1), CLOSE(2);

    private final int index;

    GameCommand(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public static GameCommand from(int index) {
        if (index == RESTART.getIndex()) {
            return RESTART;
        }
        if (index == CLOSE.getIndex()) {
            return CLOSE;
        }
        throw new NotSUpportCommandException();
    }

    public static class NotSUpportCommandException extends IllegalAccessError {
    }
}