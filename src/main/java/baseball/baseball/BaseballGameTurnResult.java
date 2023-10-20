package baseball.baseball;

import baseball.game.turn.TurnResult;

public class BaseballGameTurnResult implements TurnResult {
    int numStrike;
    int numBall;

    public BaseballGameTurnResult(int numBall, int numStrike) {
        this.numBall = numBall;
        this.numStrike = numStrike;
    }


    @Override
    public boolean isGameCleared() {
        return numStrike == 3;
    }

    public int getNumStrike() {
        return numStrike;
    }

    public int getNumBall() {
        return numBall;
    }
}
