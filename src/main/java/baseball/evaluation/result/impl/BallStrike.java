package baseball.evaluation.result.impl;

import baseball.evaluation.result.EvalResult;

public class BallStrike implements EvalResult {
    private final int ball;
    private final int strike;
    private final boolean isSuccess;

    public BallStrike(int ball, int strike, boolean isSuccess) {
        this.ball = ball;
        this.strike = strike;
        this.isSuccess = isSuccess;
    }

    @Override
    public void printResult() {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else {
            if (ball != 0) {
                System.out.printf("%d 볼 ", ball);
            }
            if (strike != 0) {
                System.out.printf("%d 스트라이크%n", strike);
            }
        }
        if (isSuccess) {
            System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임종료%n", strike);
        }
    }

    @Override
    public boolean isClear() {
        return isSuccess;
    }
}
