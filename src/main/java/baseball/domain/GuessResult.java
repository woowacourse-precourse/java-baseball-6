package baseball.domain;

public record GuessResult(int ballCount, int strikeCount) {
    public boolean hasBall() {
        return ballCount > 0;
    }

    public boolean hasStrike() {
        return strikeCount > 0;
    }

    public boolean isAllStrike() {
        return strikeCount == 3;
    }
}
