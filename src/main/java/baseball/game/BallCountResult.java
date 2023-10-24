package baseball.game;

import static baseball.game.BaseballConstants.MAX_STRIKES;

public record BallCountResult(int ballCount, int strikeCount) {

    public boolean isStrikeOut() {
        return strikeCount >= MAX_STRIKES;
    }
}
