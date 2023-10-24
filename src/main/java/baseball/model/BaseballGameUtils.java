package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameUtils {

    public BaseballGameUtils() {

    }

    public Score checkScore(List<Integer> computerNumber, List<Integer> userNumber) {

        int ball = 0;
        int strike = 0;

        ball = checkBall(computerNumber, userNumber);
        strike = checkStrike(computerNumber, userNumber);

        return new Score(ball, strike);
    }

    public int checkBall(List<Integer> computerNumber, List<Integer> userNumber) {

        int count = 0;

        for (int i = 0; i < computerNumber.size(); i++) {
            if (computerNumber.contains(userNumber.get(i)) && computerNumber.indexOf(userNumber.get(i)) != i)
                count++;
        }

        return count;
    }

    public int checkStrike(List<Integer> computerNumber, List<Integer> userNumber) {

        int count = 0;

        for (int i = 0; i < computerNumber.size(); i++) {
            if (computerNumber.get(i) == userNumber.get(i)) {
                count++;
            }
        }

        return count;
    }

}
