package baseball.model;

import static constants.BallDetails.BALL_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BallGenerator {

    public static Ball generateBall() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < BALL_SIZE) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return new Ball(numbers);
    }
}
