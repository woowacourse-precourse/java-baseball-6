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

    public static Score getScore(List<Integer> answerNumbers, List<Integer> userNumbers) {

        int strike = calculateStrike(answerNumbers, userNumbers);
        int ball = calculateBall(answerNumbers, userNumbers);
        Score score = new Score();
        score.strike = strike;
        score.ball = ball;
        return score;
    }


    private static int calculateStrike(List<Integer> answerNumbers, List<Integer> userNumbers) {

        int strike = 0;

        for(int i = 0; i < answerNumbers.size(); i++) {
            for(int j = 0; j < userNumbers.size(); j++) {
                if((i == j) && (answerNumbers.get(i) == userNumbers.get(j))) {
                    strike++;
                }
            }
        }

        return strike;
    }

    private static int calculateBall(List<Integer> answerNumbers, List<Integer> userNumbers) {

        int ball = 0;

        for(int i = 0; i < answerNumbers.size(); i++) {
            for(int j = 0; j < userNumbers.size(); j++) {
                if((i != j) && (answerNumbers.get(i) == userNumbers.get(j))) {
                    ball++;
                }
            }
        }

        return ball;
    }
}
