package baseball.utils.match;

import java.util.ArrayList;
import java.util.List;

public class MatchResults {
    private int strike;
    private int ball;

    public MatchResults() {
        this.strike = 0;
        this.ball = 0;
    }

    public void match(MatchResult matchResult) {
        if (matchResult.isStrike()) {
            this.strike++;
        }
        if (matchResult.isBall()) {
            this.ball++;
        }
    }

    public boolean isAllStrike() {
        return strike == 3;
    }

    public String getResultMessage() {
        if (strike == 0 && ball == 0) {
            return MatchResult.NOTHING.getName();
        }

        List<String> result = new ArrayList<>();
        if (ball > 0) {
            result.add(ball + MatchResult.BALL.getName());
        }
        if (strike > 0) {
            result.add(strike + MatchResult.STRIKE.getName());
        }

        return String.join(" ", result);
    }
}
