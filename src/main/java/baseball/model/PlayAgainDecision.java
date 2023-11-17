package baseball.model;

import static baseball.exception.ErrorMessage.INVALID_PLAY_AGAIN;
import static baseball.model.PlayAgainDecision.PlayAgainConstants.*;

public class PlayAgainDecision {
    private final int value;

    private PlayAgainDecision(int input) {
        value = input;
    }

    public static PlayAgainDecision of(int input) {
        validate(input);
        return new PlayAgainDecision(input);
    }

    private static void validate(int input) {
        if ((input != YES.value) && (input != NO.value)) {
            throw new IllegalArgumentException(INVALID_PLAY_AGAIN.getMessage());
        }
    }

    public boolean isAgain() {
        return value == YES.value;
    }

    enum PlayAgainConstants {
        YES(1),
        NO(2);

        private final int value;

        PlayAgainConstants(int value) {
            this.value = value;
        }
    }
}
