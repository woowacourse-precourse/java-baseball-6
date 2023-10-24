package baseball;

import java.util.List;

public class CompareNumber {
    int ball;
    int strike;

    public int[] getCompareResult(List<Integer> user, List<Integer> computer) {
        initCount();
        countBall(user, computer);
        countStrike(user, computer);
        computeBallWithoutStrike();

        return new int[]{ball, strike};
    }

    public void initCount() {
        ball = 0;
        strike = 0;
    }

    public void countBall(List<Integer> user, List<Integer> computer) {
        for (int i = 0; i < user.size(); i++) {
            if (computer.contains(user.get(i))) {
                ball++;
            }
        }
    }

    public void countStrike(List<Integer> user, List<Integer> computer) {
        for (int i = 0; i < user.size(); i++) {
            if (computer.get(i).equals(user.get(i))) {
                strike++;
            }
        }
    }

    public void computeBallWithoutStrike() {
        ball = ball - strike;
    }

    public boolean isStrikeThree() {
        if (strike == 3) {
            return true;
        }
        return false;
    }
}
