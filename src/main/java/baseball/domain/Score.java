package baseball.domain;

public class Score {

    private int strike;
    private int ball;

    public static Score create(Balls answerBalls, Balls userBalls) {

        Score score = new Score();
        score.strike = userBalls.calculateStrike(answerBalls);
        score.ball = userBalls.calculateBall(answerBalls);
        return score;
    }

    public int getStrike() {

        return strike;
    }

    public int getBall() {

        return ball;
    }

    public boolean isAllStrike() {

        if(strike == 3) {
            return true;
        }

        return false;
    }
}
