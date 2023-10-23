package baseball.baseball;

import static baseball.common.Constant.BALL_AMOUNT;
import static baseball.common.Constant.MAX_BALL_NUMBER;
import static baseball.common.Constant.MIN_BALL_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseBall {

    private final List<Integer> ballNumbers;

    public BaseBall() {
        this.ballNumbers = generatedRandomBallNumbers();
    }

    public Result getPlayResult(List<Integer> targetBallNumbers) {
        Result result = new Result();

        for (int i = 0; i < BALL_AMOUNT; i++) {
            Integer ballNumber = this.ballNumbers.get(i);
            Integer targetBallNumber = targetBallNumbers.get(i);

            increaseStrike(result, ballNumber, targetBallNumber);
            increaseBall(result, ballNumber, targetBallNumber);
        }
        return result;
    }

    private void increaseStrike(Result result, Integer ballNumber, Integer targetNumber) {
        if (ballNumber.equals(targetNumber)) {
            result.increaseStrikeCount();
        }
    }

    private void increaseBall(Result result, Integer ballNumber, Integer targetNumber) {
        if (!ballNumber.equals(targetNumber) && this.ballNumbers.contains(targetNumber)) {
            result.increaseBallCount();
        }
    }

    private List<Integer> generatedRandomBallNumbers() {
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
