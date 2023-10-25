package baseball.model;

import java.util.List;

public class Score {
    private int balls;
    private int strikes;

    public Score() {
        this.balls = 0;
        this.strikes = 0;
    }

    public void resetScore() {
        this.balls = 0;
        this.strikes = 0;
    }

    public void countScore(List<Integer> userNumber, List<Integer> computerNumber) {
        for (int i = 0; i < 3; i++) {

            if (userNumber.get(i).equals(computerNumber.get(i))) {
                this.strikes++;
                continue;
            }

            if (computerNumber.contains(userNumber.get(i))) {
                this.balls++;
            }
        }
    }

    public int getBall() {
        return balls;
    }

    public int getStrike() {
        return strikes;
    }
}
