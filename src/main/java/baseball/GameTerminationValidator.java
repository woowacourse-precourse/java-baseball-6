package baseball;

import static baseball.BaseballConstants.*;

public class GameTerminationValidator implements Validator {
    @Override
    public void validate(String input) {
        if (!input.matches("[" + START_GAME_NUMBER + END_GAME_NUMBER + "]")) {
            throw new IllegalArgumentException(VALIDATE_ERROR_MESSAGE);
        }
    }
}
