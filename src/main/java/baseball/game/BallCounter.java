package baseball.game;

import java.util.List;

public class BallCounter {

    public Integer countStrike(List<Integer> userNum, List<Integer> comNum) {
        int strike = 0;
        for (int i = 0; i < userNum.size(); i++) {
            if (userNum.get(i) == comNum.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    public Integer countCorrect(List<Integer> userNum, List<Integer> comNum) {
        int correct = 0;
        for (int i = 0; i < userNum.size(); i++) {
            if (comNum.contains(userNum.get(i))) {
                correct++;
            }
        }
        return correct;
    }
}
