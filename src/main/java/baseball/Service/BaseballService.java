package baseball.Service;

import java.util.List;
import java.util.Objects;

public class BaseballService {

    public int[] checkNumber(List<Integer> answerNumber, List<Integer> userNumber) {
        int[] ballCount = new int[2];
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < answerNumber.size(); i++) {
            if (Objects.equals(answerNumber.get(i), userNumber.get(i))) {
                strike++;
            } else if (answerNumber.contains(userNumber.get(i))) {
                ball++;
            }
        }

        ballCount[0] = ball;
        ballCount[1] = strike;

        return ballCount;
    }

    public boolean checkGameSet(int[] ballCount) {
        return ballCount[1] == 3;
    }
}
