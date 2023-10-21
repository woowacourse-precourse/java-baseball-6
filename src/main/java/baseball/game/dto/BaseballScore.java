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

    @Override
    public String toString() {
        if (isEmpty()) {
            return "낫싱";
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean isNeedSpace = ballCount > 0;
        if (ballCount > 0) {
            stringBuilder.append(ballCount).append("볼");
        }
        if (isNeedSpace) {
            stringBuilder.append(" ");
        }
        if (strikeCount > 0) {
            stringBuilder.append(strikeCount).append("스트라이크");
        }
        return stringBuilder.toString();
    }
}
