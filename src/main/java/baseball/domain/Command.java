package baseball.domain;

public enum Command {
    RESTART("1", true),
    END("2", false);

    private final String command;
    private final boolean isRestart;

    Command(String command, boolean isRestart) {
        this.command = command;
        this.isRestart = isRestart;
    }

    public static Command findByCommand(String inputCommand) {
        for (Command command : Command.values()) {
            if (command.getCommand().equals(inputCommand)) {
                return command;
            }
        }
        throw new IllegalArgumentException("잘못된 명령어를 입력했습니다.");
    }

    public String getCommand() {
        return command;
    }

    public boolean isRestart() {
        return isRestart;
    }

}
