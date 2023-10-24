package baseball.Domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballScore {

    private final int ball, strike;

    public BaseballScore(int ball, int strike) {
        this.ball = ball; this.strike = strike;
    }

    @Override
    public String toString() {
        List<String> parts = new ArrayList<>();
        buildString(parts, ball, "볼");
        buildString(parts, strike, "스트라이크");
        return parts.isEmpty()? "낫싱" : String.join(" ", parts);
    }

    private void buildString(List<String> parts, int count, String label) {
        if(count > 0) parts.add(count + label);
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }
}
