package baseball.domain;

public class Score {

    private Strike strike;
    private Ball ball;

    public static Score create(Balls answerBalls, Balls userBalls) {

        Score score = new Score();
        score.strike = new Strike(userBalls.calculateStrike(answerBalls));
        score.ball = new Ball(userBalls.calculateBall(answerBalls));
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
