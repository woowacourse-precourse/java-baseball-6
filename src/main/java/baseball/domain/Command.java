package baseball.domain;

public enum Command {
    RESTART("1"),
    END("2");

    private final String command;

    Command(String command) {
        this.command = command;
    }

    public static Command findCommand(String inputCommand) {
        for(Command command : Command.values()) {
            if(command.getCommand().equals(inputCommand)) {
                return command;
            }
        }
        throw new IllegalArgumentException();
    }

    public String getCommand() {
        return command;
    }

}
