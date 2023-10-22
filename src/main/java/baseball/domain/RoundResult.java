package baseball.domain;

public final class RoundResult {
    private final int ballCount;
    private final int strikeCount;

    public RoundResult(GameNumbers userGameNumbers, GameNumbers computerGameNumbers) {
        this.ballCount = computerGameNumbers.countBall(userGameNumbers);
        this.strikeCount = computerGameNumbers.countStrike(userGameNumbers);
    }
}
