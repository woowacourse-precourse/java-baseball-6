package baseball;

import java.util.List;

public class CalculateResult {
    int strikeCount = 0;
    int ballCount = 0;

    public CalculateResult(List<Integer> computerBall, List<Integer> playerBall) {
        for(int i = 0; i < playerBall.size(); i++) {
            int value = playerBall.get(i);
            countBall(computerBall, value, i);
        }
    }

    public void countBall(List<Integer> computerBall, int value, int i) {
        if(computerBall.contains(value) && computerBall.indexOf(value) != i) {
            this.ballCount += 1;
        }
        if(computerBall.contains(value) &&  computerBall.indexOf(value) == i) {
            this.strikeCount += 1;
        }
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
