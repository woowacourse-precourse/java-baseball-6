package baseball.game.dto;

public record BaseballMatchResults(int ballCount, int strikeCount) {

    public boolean isEmpty() {
        return ballCount == 0 && strikeCount == 0;
    }

    public boolean isStrike() {
        return strikeCount == 3;
    }

    public static BaseballMatchResults of(int ballCount, int strikeCount) {
        return new BaseballMatchResults(ballCount, strikeCount);
    }
}
