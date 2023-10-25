package score;

import java.util.List;
import player.BaseballNumber;

public class BaseballScore {

    private int strike;
    private int ball;

    public BaseballScore() {
        this.strike = 0;
        this.ball = 0;
    }

    public void calculateStrikeAndBall(List<BaseballNumber> playerNumbers,
                                       List<BaseballNumber> otherPlayerNumbers) {
        for (int i = 0; i < playerNumbers.size(); i++) {
            BaseballNumber playerNumber = playerNumbers.get(i);
            BaseballNumber otherPlayerNumber = otherPlayerNumbers.get(i);

            if (playerNumber.equals(otherPlayerNumber)) {
                strike++;
                continue;
            }

            if (playerNumbers.contains(otherPlayerNumber)) {
                ball++;
            }
        }
    }

    public void clearStrikeAndBall() {
        strike = 0;
        ball = 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
