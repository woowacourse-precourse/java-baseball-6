package baseball.model;

import java.util.List;

public class PlayResult {
    public static final String SPACE = " ";
    public static final String STRIKE_STRING = "스트라이크";
    public static final String BALL_STRING = "볼";
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
        if (strikeCount != 0 && ballCount == 0) {
            return strikeCount + STRIKE_STRING;
        }

        if (strikeCount != 0 && ballCount != 0) {
            return ballCount + BALL_STRING + SPACE + strikeCount + STRIKE_STRING;
        }

        if (strikeCount == 0 && ballCount != 0) {
            return ballCount + BALL_STRING;
        }

        return "낫싱";
    }

    public boolean isCorrect() {
        return strikeCount == 3;
    }
}
