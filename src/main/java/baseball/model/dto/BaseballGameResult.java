package baseball.model.dto;

import baseball.model.BaseballGame;

public class BaseballGameResult {

    private final int ball;
    private final int strike;

    private BaseballGameResult(final int ball, final int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public static BaseballGameResult from(final BaseballGame baseballGame) {
        return new BaseballGameResult(baseballGame.getBall(), baseballGame.getStrike());
    }

    public int getBallCount() {
        return ball;
    }

    public int getStrikeCount() {
        return strike;
    }
}
