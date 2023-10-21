package baseball.domain.command;

import static baseball.domain.command.GameCommands.RESTART;

import baseball.domain.command.validation.CommandValidator;

public class Command {

    private final Integer command;

    public Command(Integer command) {
        CommandValidator.validate(command);
        this.command = command;
    }

    public boolean isRestartCommand() {
        return command.equals(RESTART);
    }
}
