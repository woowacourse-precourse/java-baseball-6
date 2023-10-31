package baseball.domain.util.calculator;

import baseball.domain.entity.ScoreBoard;
import java.util.List;

public class BallAndStrikeCalculator {
    public ScoreBoard calculate(List<Integer> attempt, List<Integer> target) {
        ScoreBoard scoreBoard = new ScoreBoard();

        for (int i = 0; i < attempt.size(); i++) {
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
