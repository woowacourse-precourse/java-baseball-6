package baseball.model;

import static constants.BallDetails.BALL_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BallGenerator {

    public static Ball generateBall() {
        List<Integer> digits = new ArrayList<>();
        while (digits.size() < BALL_SIZE) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!digits.contains(number)) {
                digits.add(number);
            }
        }
        return new Ball(digits);
    }
}
