package baseball;

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

        Score score = new Score();
        int strike = 0;
        int ball = 0;

        for(int i = 0; i < answerNumbers.size(); i++) {
            for(int j = 0; j < userNumbers.size(); j++) {
                if((i == j) && (answerNumbers.get(i) == userNumbers.get(j))) {
                    strike++;
                    continue;
                }
                if(answerNumbers.get(i) == userNumbers.get(j)) {
                    ball++;
                }
            }
        }

        score.strike = strike;
        score.ball = ball;
        return score;
    }
}
