package baseball.model;

import baseball.model.rule.BaseBallGameRule;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;
import java.util.Set;

public class BaseBallGameComputer extends BaseBallGameRule {
    private Set<Ball> balls;
    public BaseBallGameComputer() {
    }

    public void readyForGame() {
        this.balls = new LinkedHashSet<>();
        while (balls.size() < BASEBALL_MAX_AMOUNT) {
            int randomNumber = pickNumberFromThreadLocalRandomForBalls(BASEBALL_MIN_VALUE,BASEBALL_MAX_VALUE);
            balls.add(new Ball(randomNumber));
        }
    }

    public Integer pickNumberFromThreadLocalRandomForBalls(int minValue, int maxValue) {
        return Randoms.pickNumberInRange(minValue, maxValue);
    }

    public Hint getHintByPlayer(Set<Ball> playerBalls) {
        int[] counts = computeBallAndStrikeCounts(playerBalls);
        int ballCount = counts[0];
        int strikeCount = counts[1];
        return new Hint(strikeCount, ballCount);
    }

    private int[] computeBallAndStrikeCounts(Set<Ball> playerBalls) {
        int ballCount = 0;
        int strikeCount = 0;
        int computeIndex = 0;

        for (Ball computeBall : balls) {
            computeIndex++;
            int playerIndex = 0;
            for (Ball playerBall : playerBalls) {
                playerIndex++;
                if (playerBall.equals(computeBall)) {
                    if (computeIndex == playerIndex) {
                        strikeCount++;
                    } else {
                        ballCount++;
                    }
                    break;
                }
            }
        }

        return new int[]{ballCount, strikeCount};
    }
}
