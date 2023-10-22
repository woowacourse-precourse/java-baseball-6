package baseball.logic;

import java.util.List;
import java.util.stream.IntStream;

import static baseball.constant.Constant.*;

public class GameManage {

    private int strike;
    private int ball;

    public void init() {
        strike = 0;
        ball = 0;
    }

    public int getStrikeCount() {
        return this.strike;
    }

    public int getBallCount() {
        return this.ball;
    }

    public void getResult(List<Integer> answerNumbers, List<Integer> userNumbers) {
        checkStrikeCount(answerNumbers, userNumbers);
        checkBallCount(answerNumbers, userNumbers);
    }

    private void checkStrikeCount(List<Integer> answerNumbers, List<Integer> userNumbers) {
        strike = (int) IntStream.range(0, NUMBER_LENGTH)
                .filter(i -> isStrike(answerNumbers, userNumbers, i))
                .count();
    }

    private void checkBallCount(List<Integer> answerNumbers, List<Integer> userNumbers) {
        ball = (int) IntStream.range(0, NUMBER_LENGTH)
                .filter(i -> isBall(answerNumbers, userNumbers, i))
                .count();
    }

    private boolean isStrike(List<Integer> answerNumbers, List<Integer> userNumbers, int index) {
        boolean isStrike = false;
        int answer = answerNumbers.get(index);
        int user = userNumbers.get(index);

        if (answer == user) {
            isStrike = true;
        }

        return isStrike;
    }

    private boolean isBall(List<Integer> answerNumbers, List<Integer> userNumbers, int index) {
        boolean isBall = false;
        int answer = answerNumbers.get(index);
        int user = userNumbers.get(index);

        if (answer != user && answerNumbers.contains(user)) {
            isBall = true;
        }

        return isBall;
    }
}
