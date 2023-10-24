package baseball.domain;

import baseball.common.config.BaseballMessageConst;

public class BaseballResult {
    private Ball ball;
    private Strike strike;


    public BaseballResult(Ball ball, Strike strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public static BaseballResult from(int ball, int strike) {
        return new BaseballResult(Ball.of(ball), Strike.of(strike));
    }

    public boolean isGameDone() {
        return strike == Strike.THREE;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (ball.compareTo(Ball.ZERO) > 0) {
            sb.append(String.format(BaseballMessageConst.BALL_MESSAGE, ball.getBallCount())).append(" ");
        }
        if (strike.compareTo(Strike.ZERO) > 0) {
            sb.append(String.format(BaseballMessageConst.STRIKE_MESSAGE, strike.getStrikeCount()));
        }
        if (strike == Strike.ZERO && ball == Ball.ZERO) {
            sb.append(BaseballMessageConst.NOTHING_MESSAGE);
        }
        return sb.toString();
    }
}
