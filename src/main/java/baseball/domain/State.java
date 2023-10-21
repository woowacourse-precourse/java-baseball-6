package baseball.domain;

import baseball.exception.state.NotMatchGameStateException;

public class State {

    private static final int RESTART_STATE_NUMBER = 1;
    private static final int FINISH_STATE_NUMBER = 2;

    private boolean restart;

    public boolean isMoreGame() {
        return restart;
    }

    public void changeState(final int stateNumber) {
        validateStateNumber(stateNumber);
        checkRestart(stateNumber);
    }

    private void validateStateNumber(final int stateNumber) {
        if (!isStateNumber(stateNumber)) {
            throw new NotMatchGameStateException(stateNumber);
        }
    }

    private void checkRestart(final int stateNumber) {
        if (isRestart(stateNumber)) {
            restart = true;
        }
    }

    private boolean isStateNumber(final int stateNumber) {
        return isRestart(stateNumber) || isFinish(stateNumber);
    }

    private boolean isRestart(final int stateNumber) {
        return stateNumber == RESTART_STATE_NUMBER;
    }

    private boolean isFinish(final int stateNumber) {
        return stateNumber == FINISH_STATE_NUMBER;
    }

    public void end() {
        restart = false;
    }
}
