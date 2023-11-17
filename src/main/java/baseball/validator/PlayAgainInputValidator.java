package baseball.validator;

import static baseball.exception.ErrorMessage.INVALID_PLAY_AGAIN;

public class PlayAgainInputValidator {
    public static int safeParseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_PLAY_AGAIN.getMessage());
        }
    }
}
