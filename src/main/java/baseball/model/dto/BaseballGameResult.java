package baseball.model.dto;

import baseball.model.BaseballGame;

public class BaseballGameResult {
    private int ball;
    private int strike;

    private BaseballGameResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public static BaseballGameResult from(BaseballGame baseballGame) {
        return new BaseballGameResult(baseballGame.getBall(), baseballGame.getStrike());
    }

    public int getBallCount() {
        return ball;
    }

    public int getStrikeCount() {
        return strike;
    }
}
