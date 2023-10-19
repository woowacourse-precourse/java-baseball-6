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

    public boolean isCorrectAnswer(List<Integer> answerNumber, List<Integer> userNumber) {
        computeResult(answerNumber, userNumber);
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else{
            showResult();
            return false;
        }
    }

    private void showResult() {
        if (ball == INIT_BALL_STIRKE && strike == INIT_BALL_STIRKE) {
            System.out.println("낫싱");
            return;
        }
        if (ball != INIT_BALL_STIRKE && strike == INIT_BALL_STIRKE){
            System.out.println(ball + "볼");
        }
        if (ball == INIT_BALL_STIRKE && strike != INIT_BALL_STIRKE) {
            System.out.println(strike +"스트라이크");
        }
        if (ball != INIT_BALL_STIRKE && strike != INIT_BALL_STIRKE) {
            System.out.println(ball + "볼" + " " + strike + "스트라이크");
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
