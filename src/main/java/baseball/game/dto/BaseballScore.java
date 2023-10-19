package baseball.game.dto;

public record BaseballScore(int ballCount, int strikeCount) {

    public boolean isEmpty() {
        return ballCount == 0 && strikeCount == 0;
    }

    public boolean isStrike() {
        return strikeCount == 3;
    }

    public static BaseballScore of(int ballCount, int strikeCount) {
        return new BaseballScore(ballCount, strikeCount);
    }
}
