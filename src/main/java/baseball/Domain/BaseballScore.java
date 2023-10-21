package baseball.Domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballScore {

    private int ball, strike;

    public BaseballScore(int ball, int strike) {
        this.ball = ball; this.strike = strike;
    }

    @Override
    public String toString() {
        List<String> parts = new ArrayList<>();
        if(ball > 0) parts.add(ball + "볼");
        if(strike > 0) parts.add(strike + "스트라이크");
        return parts.isEmpty()? "낫싱" : String.join(" ", parts);
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }
}
