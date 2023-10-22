package baseball.model;

import static baseball.model.enums.RestartOrExitCommand.EXIT_GAME;
import static baseball.model.enums.RestartOrExitInputErrorMessage.INVALID_CHARACTER;
import static baseball.model.enums.RestartOrExitInputErrorMessage.INVALID_LENGTH;

import baseball.model.enums.RestartOrExitCommand;
import java.util.List;

public class RestartOrExitInput extends PlayerInput {
    private static final int VALID_INPUT_LENGTH = 1;

    public RestartOrExitInput(String input) {
        super(input);
        validate();
    }

    @Override
    protected void validate() {
        super.validate();
        checkInputLength();
        checkInputCommand();
    }

    private void checkInputLength() {
        if (input.length() != VALID_INPUT_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH.getMessage());
        }
    }

    private void checkInputCommand() {
        List<String> validCommands = RestartOrExitCommand.getCommands();
        if (!validCommands.contains(input)) {
            throw new IllegalArgumentException(INVALID_CHARACTER.getMessage());
        }
    }

    public boolean isExitInput() {
        return input.equals(EXIT_GAME.getCommand());
    }
}
