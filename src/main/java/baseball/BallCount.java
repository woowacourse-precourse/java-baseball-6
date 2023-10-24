package baseball;

import java.util.List;

public class BallCount {
    private int strikeCount;
    private int ballCount;

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void calculate(List<Integer> computerNumber, List<Integer> userNumber) {
        calculateStrikeCount(computerNumber, userNumber);
        calculateBallCount(computerNumber, userNumber);
    }

    private void calculateStrikeCount(List<Integer> computerNumber, List<Integer> userNumber) {
        strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumber.get(i) == userNumber.get(i)) {
                strikeCount++;
            }
        }
    }

    private void calculateBallCount(List<Integer> computerNumber, List<Integer> userNumber) {
        ballCount = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumber.get(i) != userNumber.get(i) && computerNumber.contains(userNumber.get(i))) {
                ballCount++;
            }
        }
    }
}
