package baseball.model;

import baseball.valueObject.BallInfo;
import baseball.valueObject.ResultBall;

import java.util.List;

public class BallChecker {
    private final static int ZERO = 0;
    private final static int THREE_STRIKE = 3;

    private final List<Integer> checker;
    private boolean isContinue = true;

    public BallChecker(List<Integer> inputBalls) {
        this.checker = inputBalls;
    }

    public boolean isContinue(){
        return isContinue;
    }

    private void setIsContinueByStrike(int strike) {
        if (strike == THREE_STRIKE) {
            isContinue = false;
        }
    }

    public ResultBall getBallInfo(BallInfo ballInfo) {
        List<Integer> inputBallList = ballInfo.getBallInputList();
        int ball = ZERO;
        int strike = ZERO;

        for (int i = ZERO; i < checker.size(); i++) {
            Integer randomBall = checker.get(i);
            Integer userBall = inputBallList.get(i);

            if (randomBall == userBall) {
                strike++;
            } else if (checker.contains(userBall)) {
                ball++;
            }
        }

        setIsContinueByStrike(strike);
        return new ResultBall(ball, strike);
    }
}
