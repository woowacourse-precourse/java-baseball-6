package score;

import java.util.List;

public class BaseballScore {

    private int strike;
    private int ball;

    public BaseballScore() {
        this.strike = 0;
        this.ball = 0;
    }

    public void calculateStrikeAndBall(List<Integer> playerNumbers,
                                       List<Integer> otherPlayerNumbers) {
        for (int i = 0; i < playerNumbers.size(); i++) {
            Integer playerNumber = playerNumbers.get(i);
            Integer otherPlayerNumber = otherPlayerNumbers.get(i);

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
