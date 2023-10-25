package baseball.domain;

import java.util.List;

public class BallCounter {

    private int strikeCount;
    private int ballCount;

    public BallCounter(List<Integer> targetNumber, List<Integer> guessNumber) {
        int index = 0;

        for (int ball : targetNumber) {
            if (isStrike(guessNumber, ball, index++)) {
                ++strikeCount;
            } else if (isBall(guessNumber, ball)) {
                ++ballCount;
            }
        }
    }

    private boolean isStrike(List<Integer> guessNumber, int ball, int index) {
        return guessNumber.get(index) == ball;
    }

    private boolean isBall(List<Integer> guessNumber, int ball) {
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
            return "낫싱\n";
        }
        return (ballString + strikeString).trim();
    }

    private boolean isNotting(String ballString, String strikeString) {
        return ballString.isEmpty() && strikeString.isEmpty();
    }
}
