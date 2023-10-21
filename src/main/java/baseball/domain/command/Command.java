package baseball.domain.command;

import static baseball.domain.command.GameCommands.RESTART;

public class Command {

    private final Integer command;

    public Command(Integer command) {
        this.command = command;
    }

    public boolean isRestartCommand() {
        return command.equals(RESTART);
    }
}
