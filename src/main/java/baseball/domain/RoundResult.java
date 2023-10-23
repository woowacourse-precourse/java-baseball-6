package baseball.domain;

import baseball.domain.gamenumber.GameNumbers;

public final class RoundResult {
    private final int ballCount;
    private final int strikeCount;

    public RoundResult(GameNumbers userGameNumbers, GameNumbers computerGameNumbers) {
        this.ballCount = computerGameNumbers.countBall(userGameNumbers);
        this.strikeCount = computerGameNumbers.countStrike(userGameNumbers);
    }

    public boolean isNothing() {
        return ballCount == 0 && strikeCount == 0;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
