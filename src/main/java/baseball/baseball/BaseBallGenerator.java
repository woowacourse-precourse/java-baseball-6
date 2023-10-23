package baseball.baseball;

import static baseball.common.Constant.BALL_AMOUNT;
import static baseball.common.Constant.MAX_BALL_NUMBER;
import static baseball.common.Constant.MIN_BALL_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseBallGenerator {

    public List<Integer> generatedRandomBallNumbers() {
        List<Integer> ballNumbers = new ArrayList<>();

        while (ballNumbers.size() < BALL_AMOUNT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER);
            addBallNumber(ballNumbers, randomNumber);
        }

        return ballNumbers;
    }

    private void addBallNumber(List<Integer> ballNumbers, int randomNumber) {
        if (!ballNumbers.contains(randomNumber)) {
            ballNumbers.add(randomNumber);
        }
    }

}
