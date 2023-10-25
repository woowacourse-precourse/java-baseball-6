package baseball.model;

import baseball.model.ball.Ball;
import baseball.model.ball.Balls;

public class BallCounter {

    private int strikeCount;
    private int ballCount;

    public BallCounter(Balls targetNumber, Balls guessNumber) {
        int index = 0;

        for (Ball ball : targetNumber) {
            if (isStrike(guessNumber, ball, index++)) {
                ++strikeCount;
            } else if (isBall(guessNumber, ball)) {
                ++ballCount;
            }
        }
    }

    private boolean isStrike(Balls guessNumber, Ball ball, int index) {
        return guessNumber.get(index).equals(ball);
    }

    private boolean isBall(Balls guessNumber, Ball ball) {
        return guessNumber.contains(ball);
    }

    public boolean isAllStrike(final int NUMBER_BALLS) {
        return strikeCount == NUMBER_BALLS;
    }

    private String getBall() {
        if (ballCount > 0) {
            return ballCount + "볼 ";
        }
        return "";
    }

    private String getStrike() {
        if (strikeCount > 0) {
            return strikeCount + "스트라이크 ";
        }
        return "";
    }

    @Override
    public String toString() {
        String ballString = getBall();
        String strikeString = getStrike();

        if (isNotting(ballString, strikeString)) {
            return "낫싱";
        }
        return (ballString + strikeString).trim();
    }

    private boolean isNotting(String ballString, String strikeString) {
        return ballString.isEmpty() && strikeString.isEmpty();
    }
}
