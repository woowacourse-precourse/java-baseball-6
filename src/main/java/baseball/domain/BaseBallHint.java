package baseball.domain;

public record BaseBallHint(
        int ball,
        int strike
) {

    public boolean isNothing() {
        return !hasBall() && !hasStrike();
    }

    public boolean hasBall() {
        return ball != 0;
    }

    public boolean hasStrike() {
        return strike != 0;
    }

    public boolean hasThreeStrike() {
        return strike == 3;
    }
}
