package baseball.domain.controller;

import java.util.List;

public class BallAndStrikeCalculator {
    public int[] calculate(List<Integer> attempt, List<Integer> target) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < attempt.size(); i++) {
            ball += countBall(attempt, target, i);
            strike += countStrike(attempt, target, i);
        }

        return new int[]{ball, strike};
    }

    private int countStrike(List<Integer> attempt, List<Integer> target, int index) {
        Integer attemptValue = attempt.get(index);
        Integer targetValue = target.get(index);

        if (attemptValue.equals(targetValue)) {
            return 1;
        }
        return 0;
    }

    private int countBall(List<Integer> attempt, List<Integer> target, int index) {
        Integer attemptValue = attempt.get(index);

        if (!attemptValue.equals(target.get(index)) && target.contains(attemptValue)) {
            return 1;
        }
        return 0;
    }
}
