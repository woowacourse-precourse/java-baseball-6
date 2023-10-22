package baseball.model;

import baseball.exception.state.NotMatchGameStateException;
import java.util.Arrays;

public enum State {

    RESTART("1"),
    FINISH("2");

    private final String stateNumber;

    State(final String stateNumber) {
        this.stateNumber = stateNumber;
    }

    public static State createWith(final String stateNumber) {

        return Arrays.stream(values())
                .filter(state -> isStateNumber(stateNumber))
                .findFirst()
                .orElseThrow(() -> new NotMatchGameStateException(stateNumber));
    }

    private static boolean isStateNumber(final String stateNumber) {
        return stateNumber.equals(RESTART.stateNumber) || stateNumber.equals(FINISH.stateNumber);
    }

    public static boolean isMoreGame(final State state) {
        return RESTART == state;
    }
}
