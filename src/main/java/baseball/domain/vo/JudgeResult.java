package baseball.domain.vo;

import java.util.StringJoiner;

public record JudgeResult(
        int strike,
        int ball
) {
    public boolean isThreeStrike() {
        return strike == 3;
    }

    @Override
    public String toString() {
        if (isNothing()) {
            return "낫싱";
        }

        StringJoiner sj = new StringJoiner(" ");

        if (ball > 0) {
            sj.add(ball + "볼");
        }

        if (strike > 0) {
            sj.add(strike + "스트라이크");
        }

        return sj.toString();
    }

    private boolean isNothing() {
        return strike == 0 && ball == 0;
    }
}
