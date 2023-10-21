package baseball.domain;

public final class GameResult {
    private final int ballCount;
    private final int strikeCount;

    public GameResult(GameNumbers userGameNumbers, GameNumbers computerGameNumbers) {
        this.ballCount = computerGameNumbers.countBall(userGameNumbers);
        this.strikeCount = computerGameNumbers.countStrike(userGameNumbers);
    }

    public boolean isNothing() {
        return ballCount == 0 && strikeCount == 0;
    }
}
