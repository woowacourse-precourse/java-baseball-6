package baseball.domain;

import baseball.view.Output;

import java.util.List;

import static baseball.view.Output.*;

public class MiddleMan {
    private static final int INIT_BALL_STIRKE = 0;
    private static final int NUMBER_LENGTH = 3;
    private static final int CORRECT_STRIKE_COUNT = 3;
    private int ball;
    private int strike;

    public MiddleMan() {
        initBallStrike();
    }

    public boolean isCorrectAnswer(List<Integer> answerNumber, List<Integer> userNumber) {
        computeResult(answerNumber, userNumber);
        if (strike == CORRECT_STRIKE_COUNT) {
            printCorrectAnswer();
            return true;
        }
        showResult();
        return false;
    }

    private void showResult() {
        if (ball == INIT_BALL_STIRKE && strike == INIT_BALL_STIRKE) {
            printNothing();
            return;
        }
        if (ball != INIT_BALL_STIRKE && strike == INIT_BALL_STIRKE){
            printBall(ball);
        }
        if (ball == INIT_BALL_STIRKE && strike != INIT_BALL_STIRKE) {
            printStrike(strike);
        }
        if (ball != INIT_BALL_STIRKE && strike != INIT_BALL_STIRKE) {
            printBallStrike(ball, strike);
        }
    }

    private void computeResult(List<Integer> answerNumber, List<Integer> userNumber) {
        initBallStrike();
        countBallStrike(answerNumber, userNumber);
    }

    private void initBallStrike() {
        this.ball = INIT_BALL_STIRKE;
        this.strike = INIT_BALL_STIRKE;
    }

    private void countBallStrike(List<Integer> answerNumber, List<Integer> userNumber) {
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            int answerNum = answerNumber.get(i);
            int userNum = userNumber.get(i);
            if (answerNum == userNum) {
                strike++;
            } else if (answerNumber.contains(userNum)) {
                ball++;
            }
        }
    }
}
