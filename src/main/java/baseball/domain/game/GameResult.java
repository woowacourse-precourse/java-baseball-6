package baseball.domain.game;

import baseball.domain.ball.BallNumbers;

public record GameResult(
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
