package baseball.game;

import baseball.model.Score;
import java.util.List;

public class BaseballScoreEvaluator {
    private static final int NUMBER_COUNT = 3;

    public Score evaluate(List<Integer> targetNumbers, List<Integer> guessedNumbers) {
        int strikes = calculateStrikes(targetNumbers, guessedNumbers);
        int balls = calculateBalls(targetNumbers, guessedNumbers);
        return new Score(strikes, balls);
    }

    private int calculateStrikes(List<Integer> targetNumbers, List<Integer> guessedNumbers) {
        int strikes = 0;
        for (int i = 0; i < NUMBER_COUNT; i++) {
            if (targetNumbers.get(i).equals(guessedNumbers.get(i))) {
                strikes++;
            }
        }
        return strikes;
    }

    private int calculateBalls(List<Integer> targetNumbers, List<Integer> guessedNumbers) {
        int balls = 0;
        for (int i = 0; i < NUMBER_COUNT; i++) {
            int guessedNumber = guessedNumbers.get(i);
            if (targetNumbers.contains(guessedNumber) && !targetNumbers.get(i).equals(guessedNumbers.get(i))) {
                balls++;
            }
        }
        return balls;
    }
}
