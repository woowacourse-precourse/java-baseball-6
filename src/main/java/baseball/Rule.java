package baseball;

import java.util.List;
import java.util.Objects;

public class Rule {
    private int strike;
    private int ball;

    public Rule(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isAllStrike() {
        return strike == 3;
    }

    @Override
    public String toString() {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        StringBuilder result = new StringBuilder();

        if (ball > 0) {
            result.append(ball).append("볼 ");
        }

        if (strike > 0) {
            result.append(strike).append("스트라이크");
        }

        return result.toString().trim();
    }



}
