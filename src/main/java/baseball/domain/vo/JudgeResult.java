package baseball.domain.vo;

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
}
