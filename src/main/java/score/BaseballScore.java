package score;

import player.BaseballNumbers;

public class BaseballScore {

    private Integer strike;
    private Integer ball;

    public BaseballScore() {
        this.strike = 0;
        this.ball = 0;
    }

    public void setStrikeAndBall(BaseballNumbers computerBaseballNumber, BaseballNumbers playerBaseballNumber) {
        for (int i = 0; i < computerBaseballNumber.size(); i++) {
            if (computerBaseballNumber.get(i).equals(playerBaseballNumber.get(i))) {
                strike++;
                continue;
            }

            if (computerBaseballNumber.contains(playerBaseballNumber.get(i))) {
                ball++;
            }
        }
    }

    public void clearStrikeAndBall() {
        strike = 0;
        ball = 0;
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }
}
