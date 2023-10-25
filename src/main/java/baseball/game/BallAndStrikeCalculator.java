package baseball.game;

import java.util.List;

public class BallAndStrikeCalculator {
    /**
     * ball과 strike 계산
     *
     * @param attempt 사용자가 시도한 숫자 3개
     * @param target  컴퓨터가 생성한 숫자 3개
     * @return
     */
    public int[] calculate(List<Integer> attempt, List<Integer> target) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < attempt.size(); i++) {
            ball += countBall(attempt, target, i);
            strike += countStrike(attempt, target, i);
        }

        return new int[]{ball, strike};
    }

    /**
     * Strike 카운팅
     *
     * @param attempt 사용자가 시도한 숫자 3개
     * @param target  컴퓨터가 생성한 숫자 3개
     * @param index   몇번 째 리스트를 비교할지
     * @return counting 해야하는지
     */
    private int countStrike(List<Integer> attempt, List<Integer> target, int index) {
        Integer attemptValue = attempt.get(index);
        Integer targetValue = target.get(index);

        if (attemptValue.equals(targetValue)) {
            return 1;
        }
        return 0;
    }

    /**
     * ball 카운팅
     *
     * @param attempt 사용자가 시도한 숫자 3개
     * @param target  컴퓨터가 생성한 숫자 3개
     * @param index   몇번 째 리스트를 비교할지
     * @return counting 해야하는지
     */
    private int countBall(List<Integer> attempt, List<Integer> target, int index) {
        Integer attemptValue = attempt.get(index);

        if (!attemptValue.equals(target.get(index)) && target.contains(attemptValue)) {
            return 1;
        }
        return 0;
    }
}
