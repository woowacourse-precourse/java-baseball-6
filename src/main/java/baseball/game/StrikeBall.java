package baseball.game;

import baseball.common.Constants;

public class StrikeBall {
    private int strike;
    private int ball;

    public StrikeBall(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return this.strike;
    }

    private boolean isNoting() {
        return this.strike == 0 && this.ball == 0;
    }

    private boolean hasBallCount() {
        return this.ball > 0;
    }

    private boolean hasStrikeCount() {
        return this.strike > 0;
    }

    public boolean isStrikeSuccess() {
        return this.strike == Constants.strikeTarget;
    }

    public String makeStrikeBallMessage() {
        StringBuilder sb = new StringBuilder();

        if(isNoting()) {
            sb.append("낫싱");
        }

        if(hasBallCount()) {
            sb.append(ball).append("볼 ");
        }

        if(hasStrikeCount()) {
            sb.append(strike).append("스트라이크 ");
        }
        return sb.toString();
    }
}