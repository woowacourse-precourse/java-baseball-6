package model.referee;

import static utils.GameConstant.BASEBALL_GAME_NUMBER_LENGTH;

public final class GameScoreboard {

    private final int strike;
    private final int ball;

    public GameScoreboard() {
        this.strike = 0;
        this.ball = 0;
    }

    private GameScoreboard(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    GameScoreboard incrementStrike() {
        return new GameScoreboard(strike + 1, ball);
    }

    GameScoreboard incrementBall() {
        return new GameScoreboard(strike, ball + 1);
    }

    public boolean isThreeStrike() {
        return this.strike == BASEBALL_GAME_NUMBER_LENGTH;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

}
