package baseball.model;

import baseball.exception.state.NotMatchGameStateException;

public enum State {

    RESTART(1),
    FINISH(2);


    private final int stateNumber;

    State(final int stateNumber) {
        this.stateNumber = stateNumber;
    }

    public static boolean isMoreGame(final int stateNumber) {
        return RESTART.stateNumber == stateNumber;
    }

    public static void validate(final int stateNumber) {
        if (!isStateNumber(stateNumber)) {
            throw new NotMatchGameStateException(stateNumber);
        }
    }
    private static boolean isStateNumber(final int stateNumber) {
        return RESTART.stateNumber == stateNumber || FINISH.stateNumber == stateNumber;
    }
}
