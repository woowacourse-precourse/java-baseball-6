package baseball.model;

import java.util.List;

public class PlayResult {
    public static final String SPACE = " ";
    private int strikeCount;
    private int ballCount;

    public PlayResult(List<BallStatus> ballStatuses) {
        this.strikeCount = 0;
        this.ballCount = 0;

        ballStatuses.stream()
                .forEach(this::count);
    }

    private void count(BallStatus status) {
        if (status == BallStatus.STRIKE) strikeCount++;
        if (status == BallStatus.BALL) ballCount++;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (strikeCount == 0 && ballCount == 0) {
            result.append("낫싱");
            return result.toString();
        }

        if (strikeCount != 0) {
            result.append(strikeCount)
                    .append("스트라이크").append(SPACE);
        }
        if (ballCount != 0) {
            result.append(ballCount)
                    .append("볼");
        }

        return result.toString();
    }
}
