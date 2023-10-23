package baseball;

import java.util.List;

public class CompareNumber {
    int ball;
    int strike;

    public int[] getCompareResult(List<String> user, List<String> computer) {
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

    public void countBall(List<String> user, List<String> computer) {
        for (int i = 0; i < user.size(); i++) {
            if (computer.contains(user.get(i))) {
                ball++;
            }
        }
    }

    public void countStrike(List<String> user, List<String> computer) {
        for (int i = 0; i < user.size(); i++) {
            if (computer.get(i).equals(user.get(i))) {
                strike++;
            }
        }
    }

    public void computeBallWithoutStrike() {
        ball = strike - ball;
    }
}
