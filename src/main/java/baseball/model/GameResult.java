package baseball.model;


import baseball.BaseballScoreMessage;

public class GameResult {
    public int strike;
    public int ball;

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (ball > 0) {
            sb.append(BaseballScoreMessage.BALL.getMessageWithCount(ball)).append(" ");
        }
        if (strike > 0) {
            sb.append(BaseballScoreMessage.STRIKE.getMessageWithCount(strike)).append(" ");
        }
        if (strike == 0 && ball == 0) {
            sb.append(BaseballScoreMessage.NOTHING.toString());
        }
        return sb.toString().trim();
    }
}