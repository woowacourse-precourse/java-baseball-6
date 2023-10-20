package baseball.domain;

public record GameResult(
        int strike,
        int ball
) {

    public boolean isCompleted() {
        return strike == BaseballNumberMaker.COUNT;
    }

    public boolean isNothing() {
        return strike + ball == 0;
    }
}
