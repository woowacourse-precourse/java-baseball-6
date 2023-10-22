package baseball.model;

import static baseball.model.GameNumbers.NUMBERS_SIZE;

public class Result {

    private int strike = 0;
    private int ball = 0;

    public void countUpStrike() {
        this.strike++;
    }

    public void countUpBall() {
        this.ball++;
    }

    public void reset() {
        this.strike = 0;
        this.ball = 0;
    }

    public boolean isRunning() {
        if (strike < NUMBERS_SIZE) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (ball == 0 && strike == 0) {
            return "낫싱";
        } else if (ball == 0) {
            return strike + "스트라이크";
        } else if (strike == 0) {
            return ball + "볼";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}
