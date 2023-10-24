package baseball.model;

import java.util.Arrays;
import java.util.List;

public class BallCount {

    private int strike = 0;
    private int ball = 0;

    public BallCount(String computerNumber, String userNumber) {
        List<String> randomNumberArr = Arrays.asList(computerNumber.split(""));
        List<String> userNumberArr = Arrays.asList(userNumber.split(""));
        countStrikeAndBall(userNumberArr, randomNumberArr);
    }

    private void countStrikeAndBall(List<String> userNumberArr, List<String> randomNumberArr) {
        for (int i = 0; i < 3; i++) {
            String checkNumber = userNumberArr.get(i);
            if (randomNumberArr.get(i).equals(checkNumber)) {
                strike++;
            } else if (randomNumberArr.contains(checkNumber)) {
                ball++;
            }
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
