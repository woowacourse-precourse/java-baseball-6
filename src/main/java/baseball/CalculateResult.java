package baseball;

import java.util.List;

public class CalculateResult {
    private int strikeCount = 0;
    private int ballCount = 0;

    public CalculateResult(List<Integer> computerBall, List<Integer> playerBall) {
        for (int i = 0; i < playerBall.size(); i++) {
            int value = playerBall.get(i);
            countBall(computerBall, value, i);
        }
    }

    private void countBall(List<Integer> computerBall, int value, int i) {
        if (computerBall.contains(value) && computerBall.indexOf(value) != i) {
            this.ballCount += 1;
        }
        if (computerBall.contains(value) && computerBall.indexOf(value) == i) {
            this.strikeCount += 1;
        }
    }

    public int getStrikeCount() {
        return this.strikeCount;
    }

    public int getBallCount() {
        return this.ballCount;
    }
}
