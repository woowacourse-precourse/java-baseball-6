package baseball.model.input;

import static baseball.enums.RestartOrExitCommand.EXIT_GAME;
import static baseball.enums.RestartOrExitInputErrorMessage.INVALID_CHARACTER;
import static baseball.enums.RestartOrExitInputErrorMessage.INVALID_LENGTH;

import baseball.enums.RestartOrExitCommand;
import java.util.List;

public class RestartOrExitInput extends PlayerInput {
    private static final int VALID_INPUT_LENGTH = 1;

    public RestartOrExitInput(String input) {
        super(input);
        validate();
    }

    @Override
    protected void validate() {
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
