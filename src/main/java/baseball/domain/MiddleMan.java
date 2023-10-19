package baseball.domain;

import java.util.List;

public class MiddleMan {
    private static final int INIT_BALL_STIRKE = 0;
    private static final int NUMBER_LENGTH = 3;
    private int ball;
    private int strike;

    public MiddleMan() {
        initBallStrike();
    }

    public void computeResult(List<Integer> answerNumber, List<Integer> userNumber) {
        initBallStrike();
        countBallStrike(answerNumber, userNumber);
        System.out.println("ball = " + ball);
        System.out.println("strike = " + strike);
    }

    private void initBallStrike() {
        this.ball = INIT_BALL_STIRKE;
        this.strike = INIT_BALL_STIRKE;
    }

    private void countBallStrike(List<Integer> answerNumber, List<Integer> userNumber) {
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (answerNumber.contains(userNumber.get(i))) {
                if (answerNumber.get(i).equals(userNumber.get(i))) {
                    strike++;
                    continue;
                }
                ball++;
            }
        }
    }
}
