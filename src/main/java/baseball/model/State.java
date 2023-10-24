package baseball.model;

import baseball.exception.state.NotMatchGameStateException;
import java.util.Arrays;

public enum State {

    PLAY("1"),
    END("2");

    private final String stateNumber;

    State(final String stateNumber) {
        this.stateNumber = stateNumber;
    }

    public static State createWith(final String stateNumber) {
        validateStateNumber(stateNumber);

        return Arrays.stream(values())
                .filter(state -> state.stateNumber.equals(stateNumber))
                .findFirst()
                .orElseThrow(() -> new NotMatchGameStateException(stateNumber));
    }

    private static void validateStateNumber(final String stateNumber) {
        if (!isStateNumber(stateNumber)) {
            throw new NotMatchGameStateException(stateNumber);
        }
    }

    private static boolean isStateNumber(final String stateNumber) {
        return stateNumber.equals(PLAY.stateNumber) || stateNumber.equals(END.stateNumber);
    }

    public static boolean isMoreGame(final State state) {
        return PLAY == state;
    }
}
