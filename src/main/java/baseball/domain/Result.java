package baseball.domain;

import static baseball.common.Constants.THREE_STRIKE;

public class Result {
    private int ball;
    private int strike;

    public void report(BallHint hint) {
        if (hint.isBall()) {
            this.ball++;
        }
        if (hint.isStrike()) {
            this.strike++;
        }
    }

    public boolean isGameOver() {
        return this.strike == THREE_STRIKE;
    }

    @Override
    public String toString() {
        if (ball == 0 && strike == 0) return "낫싱";

        StringBuilder result = new StringBuilder();

        if (ball > 0) {
            result.append(ball).append("볼");
        }
        if (strike > 0) {
            result.append(" ").append(strike).append("스트라이크");
        }
        if (ball == 0 && strike > 0) {
            return result.append(strike).append("스트라이크").toString();
        }

        return result.toString();
    }
}
