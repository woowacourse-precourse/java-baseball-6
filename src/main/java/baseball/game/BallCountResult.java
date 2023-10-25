package baseball.game;

public record BallCountResult(int ballCount, int strikeCount) {

    public boolean isStrikeOut() {
        return strikeCount >= BaseballConstants.MAX_STRIKES;
    }
}
