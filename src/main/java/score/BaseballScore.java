package score;

import player.BaseballNumbers;

public class BaseballScore {

    private Strike strike;
    private Ball ball;

    public BaseballScore() {
        this.strike = new Strike();
        this.ball = new Ball();
    }

    public void setStrikeAndBall(BaseballNumbers computerBaseballNumber, BaseballNumbers playerBaseballNumber) {
        for (int i = 0; i < computerBaseballNumber.size(); i++) {
            if (computerBaseballNumber.get(i).equals(playerBaseballNumber.get(i))) {
                strike.plusOne();
                continue;
            }

            if (computerBaseballNumber.contains(playerBaseballNumber.get(i))) {
                ball.plusOne();
            }
        }
    }

    public void clearStrikeAndBall() {
        strike.clear();
        ball.clear();
    }

    public Integer getStrike() {
        return strike.getScore();
    }

    public Integer getBall() {
        return ball.getScore();
    }
}
