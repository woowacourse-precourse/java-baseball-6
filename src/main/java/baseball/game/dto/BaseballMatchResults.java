package baseball.game.dto;

public class BaseballMatchResults {

    private final int ballCount;
    private final int strikeCount;

    public BaseballMatchResults(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public static BaseballMatchResults of(int ballCount, int strikeCount) {
        return new BaseballMatchResults(ballCount, strikeCount);
    }
}
