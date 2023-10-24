package baseball.baseball;

import baseball.game.turn.TurnResult;

public class BaseballGameTurnResult implements TurnResult {

    private final boolean clear;
    private final int numStrike;
    private final int numBall;

    public BaseballGameTurnResult(boolean clear, int numBall, int numStrike) {
        this.clear = clear;
        this.numBall = numBall;
        this.numStrike = numStrike;
    }

    @Override
    public boolean isGameCleared() {
        return clear;
    }

    public int getNumStrike() {
        return numStrike;
    }

    public int getNumBall() {
        return numBall;
    }
}
