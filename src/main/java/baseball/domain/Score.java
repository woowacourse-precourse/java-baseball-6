package baseball.domain;

import java.util.List;

public class Score {

    private int strike;
    private int ball;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public static Score getScore(List<Integer> answerNumbers, Balls balls) {

        int strike = calculateStrike(answerNumbers, balls);
        int ball = calculateBall(answerNumbers, balls);
        Score score = new Score();
        score.strike = strike;
        score.ball = ball;
        return score;
    }

    public boolean isAllStrike() {

        if(strike == 3) {
            return true;
        }

        return false;
    }

    private static int calculateStrike(List<Integer> answerNumbers, Balls balls) {

        int strike = 0;

        for(int i = 0; i < answerNumbers.size(); i++) {
            for(int j = 0; j < balls.getBalls().size(); j++) {
                if((i == j) && (answerNumbers.get(i) == balls.getBalls().get(j))) {
                    strike++;
                }
            }
        }

        return strike;
    }

    private static int calculateBall(List<Integer> answerNumbers, Balls balls) {

        int ball = 0;

        for(int i = 0; i < answerNumbers.size(); i++) {
            for(int j = 0; j < balls.getBalls().size(); j++) {
                if((i != j) && (answerNumbers.get(i) == balls.getBalls().get(j))) {
                    ball++;
                }
            }
        }

        return ball;
    }
}
