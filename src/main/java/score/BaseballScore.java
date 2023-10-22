package score;

import player.BaseballNumbers;

public class BaseballScore {

    private Integer strike;
    private Integer ball;

    public BaseballScore() {
        this.strike = 0;
        this.ball = 0;
    }

    public void calculateStrikeAndBall(BaseballNumbers playerNumber,
                                       BaseballNumbers otherPlayerNumber) {
        for (int i = 0; i < playerNumber.size(); i++) {
            if (playerNumber.get(i).equals(otherPlayerNumber.get(i))) {
                strike++;
                continue;
            }

            if (playerNumber.contains(otherPlayerNumber.get(i))) {
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
