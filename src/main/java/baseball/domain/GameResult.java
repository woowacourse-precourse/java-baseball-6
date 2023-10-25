package baseball.domain;

import java.util.List;

public class GameResult {
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼 ";
    private static final String STRIKE = "스트라이크";

    private int ballCount;
    private int strikeCount;

    public void calculate(List<Integer> targetNumber, String playerNumber) {
        for (int i = 0; i < 3; i++) {
            int value = Integer.parseInt(playerNumber.substring(i, i + 1));
            if (isNothing(targetNumber, value)) {
                continue;
            }
            if (isStrike(targetNumber, value, i)) {
                this.strikeCount++;
                continue;
            }
            this.ballCount++;
        }
    }

    private boolean isNothing(List<Integer> targetNumber, int value) {
        return !targetNumber.contains(value);
    }

    private boolean isStrike(List<Integer> targetNumber, int value, int index) {
        int indexInTargetNumber = targetNumber.indexOf(value);

        return indexInTargetNumber == index;
    }

    public boolean isEnd() {
        return strikeCount == 3;
    }

    private String getMessage() {
        if (ballCount == 0 && strikeCount == 0) {
            return NOTHING;
        }

        StringBuilder builder = new StringBuilder();
        if (ballCount != 0) {
            builder.append(ballCount).append(BALL);
        }
        if (strikeCount != 0) {
            builder.append(strikeCount).append(STRIKE);
        }

        return builder.toString();
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
