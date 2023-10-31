package baseball.domain.util.calculator;

import baseball.domain.config.GameConfig;
import baseball.domain.entity.ScoreBoard;
import java.util.List;

public class BallAndStrikeCalculator {
    public static ScoreBoard calculate(List<Integer> attempt, List<Integer> target) {
        ScoreBoard scoreBoard = new ScoreBoard();

        for (int i = 0; i < GameConfig.BASEBALL_SIZE; i++) {
            Integer attemptValue = attempt.get(i);
            Integer targetValue = target.get(i);

            if (attemptValue.equals(targetValue)) {
                scoreBoard.countStrike();
                continue;
            }

            if (target.contains(attemptValue)) {
                scoreBoard.countBall();
            }
        }

        return scoreBoard;
    }
}
