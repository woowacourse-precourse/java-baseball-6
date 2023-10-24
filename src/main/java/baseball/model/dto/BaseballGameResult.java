package baseball.model.dto;

import baseball.model.BaseballGame;

public class BaseballGameResult {

    private final int ball;
    private final int strike;

    public BaseballGameResult(final BaseballGame baseballGame) {
        this.ball = baseballGame.getBall();
        this.strike = baseballGame.getStrike();
    }

    public int getBallCount() {
        return ball;
    }

    public int getStrikeCount() {
        return strike;
    }
}
