package baseball;

import java.util.List;

public class Result {
    private final int SIZE = 3;

    private int strike;
    private int ball;

    public void calc(List<Integer> computer, List<Integer> user) {
        countStrike(computer, user);
        countBall(computer, user);
    }

    public void init() {
        strike = 0;
        ball = 0;
    }

    private void countStrike(List<Integer> computer, List<Integer> user) {
        for (int i = 0; i < SIZE; i++) {
            if (computer.get(i) == user.get(i)) {
                strike++;
            }
        }
    }

    private void countBall(List<Integer> computer, List<Integer> user) {
        for (int i = 0; i < SIZE; i++) {
            if (computer.contains(user.get(i))) {
                ball++;
            }
        }
        ball -= strike;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
