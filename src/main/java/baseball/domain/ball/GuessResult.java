package baseball.domain.ball;

public record GuessResult(
        int ballCount,
        int strikeCount
) {
    public boolean hasThreeStrike() {
        return strikeCount == BallNumbers.BALL_COUNT;
    }

    public boolean hasNothing() {
        return ballCount + strikeCount == 0;
    }
}
