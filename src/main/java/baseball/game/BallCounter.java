package baseball.game;

import java.util.List;

public class BallCounter {

    private int strike;
    private int ball;
    public Integer countStrike(List<Integer> userNum, List<Integer> comNum) {
        strike = 0;
        for (int i = 0; i < userNum.size(); i++) {
            if (userNum.get(i) == comNum.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    public Integer countBall(List<Integer> userNum, List<Integer> comNum) {
        int correct = 0;
        for (int i = 0; i < userNum.size(); i++) {
            if (comNum.contains(userNum.get(i))) {
                correct++;
            }
        }
        ball = correct - strike;

        return ball;
    }
}
