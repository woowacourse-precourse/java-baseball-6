package baseball.domain;

public enum Command {
    RESTART("1"),
    END("2");

    private final String command;

    Command(String command) {
        this.command = command;
    }

    public static Command findCommand(String inputCommand) {
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

}
