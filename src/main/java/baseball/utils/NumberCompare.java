package baseball.utils;

import java.util.List;

public class NumberCompare {
    private int strike;
    private int ball;

    private void ballcount(List<Integer> computer, List<Integer> user) {
        for (int i = 0; i < 3; i++) {
            if (computer.contains(user.get(i)) && !(computer.get(i).equals(user.get(i)))) {
                ball++;
            }
        }
    }

    private void strikecount(List<Integer> computer, List<Integer> user) {
        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(user.get(i))) {
                strike++;
            }
        }
    }

    public void compareNumber(List<Integer> computer, List<Integer> user, int[] count) {
        // count[0] 스트라이크 / count[1] 볼
        strike = 0;
        ball = 0;
        strikecount(computer, user);
        ballcount(computer, user);
        count[0] = strike;
        count[1] = ball;
    }
}
