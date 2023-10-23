package baseball.baseball;

import static baseball.common.Constant.BALL_AMOUNT;

import java.util.List;

public class BaseBall {

    private final List<Integer> ballNumbers;

    public BaseBall(List<Integer> ballNumbers) {
        this.ballNumbers = ballNumbers;
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

}
