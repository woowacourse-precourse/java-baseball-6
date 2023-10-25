package baseball.manager;

public class Command {

    private static final String REPLAY_COMMAND = "1";
    private static final String NOT_REPLAY_COMMAND = "2";
    private final String command;

    public Command(String command) {
        this.command = command;
        validate();
    }

    public boolean replay() {
        return command.equals(REPLAY_COMMAND);
    }

    private void validate() {
        if (!inRange()) {
            throw new IllegalArgumentException(
                    String.format("%s이나 %s을 입력해주세요", REPLAY_COMMAND, NOT_REPLAY_COMMAND));
        }
    }

    private boolean inRange() {
        return command.equals(REPLAY_COMMAND) || command.equals(NOT_REPLAY_COMMAND);
    }
}
