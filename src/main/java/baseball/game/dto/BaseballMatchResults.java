package baseball.game.dto;

public record BaseballMatchResults(int ballCount, int strikeCount) {

    public static BaseballMatchResults of(int ballCount, int strikeCount) {
        return new BaseballMatchResults(ballCount, strikeCount);
    }
}
