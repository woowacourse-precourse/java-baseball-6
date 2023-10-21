package score;

import player.BaseballNumbers;

public class Score {
    
    private Integer strike;
    private Integer ball;

    public Score() {
        this.strike = 0;
        this.ball = 0;
    }

    public void setStrikeAndBall(BaseballNumbers computerBaseballNumber,
                                 BaseballNumbers playerBaseballNumber) {
        for (int i = 0; i < computerBaseballNumber.size(); i++) {
            if (computerBaseballNumber.get(i).equals(playerBaseballNumber.get(i))) {
                this.strike++;
                continue;
            }

            if (computerBaseballNumber.contains(playerBaseballNumber.get(i))) {
                this.ball++;
            }
        }
    }

    public void clearStrikeAndBall() {
        this.strike = 0;
        this.ball = 0;
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }
}
