package baseball.model;

import java.util.List;

import static baseball.model.BallStatus.*;

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
        if (status == STRIKE) strikeCount++;
        if (status == BALL) ballCount++;
    }

    @Override
    public String toString() {
        if (strikeCount != 0 && ballCount == 0) {
            return strikeCount + STRIKE.toString();
        }

        if (strikeCount != 0 && ballCount != 0) {
            return ballCount + BALL.toString() + SPACE + strikeCount + STRIKE.toString();
        }

        if (strikeCount == 0 && ballCount != 0) {
            return ballCount + BALL.toString();
        }

        return NOTHING.toString();
    }

    public boolean isCorrect() {
        return strikeCount == 3;
    }
}
