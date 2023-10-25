package baseball.domain;

public enum GameControlCommand {

    RESTART(1),
    END(2);

    private final int commandNumber;

    GameControlCommand(int commandNumber) {
        this.commandNumber = commandNumber;
    }

    public static GameControlCommand of(String commandNumber) throws IllegalArgumentException {
        int commandNumberInt = Integer.parseInt(commandNumber);
        for (GameControlCommand command : GameControlCommand.values()) {
            if (command.commandNumber == commandNumberInt) {
                return command;
            }
        }
        throw new IllegalArgumentException("잘못된 커멘드 입력");
    }

    public boolean isEnd() {
        return this == END;
    }
}
