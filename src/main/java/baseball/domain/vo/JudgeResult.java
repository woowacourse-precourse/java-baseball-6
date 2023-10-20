package baseball.domain.vo;

import java.util.ArrayList;
import java.util.List;

public record JudgeResult(
        int strike,
        int ball
) {
    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }

    @Override
    public String toString() {
        if(isNothing()) {
            return "낫싱";
        }

        List<String> result = new ArrayList<>();

        if(ball > 0) {
            result.add(ball + "볼");
        }

        if(strike > 0) {
            result.add(strike + "스트라이크");
        }

        return result.stream()
                .reduce((a, b) -> a + " " + b)
                .orElseThrow(IllegalStateException::new);
    }
}
