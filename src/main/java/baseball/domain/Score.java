package baseball.domain;

import java.util.List;

public class Score {

    private Strike strike;
    private Ball ball;

    public static Score getScore(List<Integer> answerNumbers, Balls balls) {

        int strike = Strike.calculateStrikeCnt(answerNumbers, balls);
        int ball = Ball.calculateBallCnt(answerNumbers, balls);
        Score score = new Score();
        score.strike = new Strike(strike);
        score.ball = new Ball(ball);
        return score;
    }

    public int getStrike() {

        return strike.getStrike();
    }

    public int getBall() {

        return ball.getBall();
    }

    public boolean isAllStrike() {

        if(strike.isAllStrike()) {
            return true;
        }

        return false;
    }


}
