package baseball.dto;

public class Command {

    private static final String RESTART = "1";
    private static final String EXIT = "2";

    private final String command;

    private Command(String command) {
        this.command = command;
    }

    public static Command from(String command) {
        return new Command(command);
    }

    public boolean orderExit() {
        return command.equals(EXIT);
    }

    public boolean orderRestart() {
        return command.equals(RESTART);
    }
}
