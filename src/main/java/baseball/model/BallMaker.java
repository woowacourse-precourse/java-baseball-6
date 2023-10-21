package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BallMaker {

    private static final int MIN_BALL_NUMBER = 1;
    private static final int MAX_BALL_NUMBER = 9;

    public BallMaker() {
    }

    public Ball createBall() {
        return new Ball(pickThreeRandomNumbersInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER));
    }

    private List<Integer> pickThreeRandomNumbersInRange(int startInclusive, int endInclusive) {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);

            if (numbers.contains(randomNumber)) {
                continue;
            }

            numbers.add(randomNumber);
        }

        return numbers;
    }

}
