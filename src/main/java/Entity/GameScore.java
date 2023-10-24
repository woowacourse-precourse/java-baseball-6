package Entity;

import static Constants.Constants.NUM_LENGTH;

import java.util.List;

public class GameScore {
    private int ball;
    private int strike;

    public GameScore() {
        ball = 0;
        strike = 0;
    }

    public void reset() {
        ball = 0;
        strike = 0;
    }

    public void calculateScore(GameNumber gameNumber) {
        List<Integer> computerNumber = gameNumber.getComputer();
        List<Integer> userNumber = gameNumber.getUser();

        for(int i = 0; i < NUM_LENGTH; i++) {
            Integer computerDigit = computerNumber.get(i);
            Integer userDigit = userNumber.get(i);
            if (computerDigit.equals(userDigit)) {
                strike++;
            } else if (computerNumber.contains(userDigit)) {
                ball++;
            }
        }
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
