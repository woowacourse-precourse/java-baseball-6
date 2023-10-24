package baseball.model;

import java.util.List;

public class BallStrikeCounter {
    private Integer ball;
    private Integer strike;

    public BallStrikeCounter() {
        this.resetBallStrike();
    }

    public void countBallStrike(List<Integer> userNumber, List<Integer> computerNumber) {
        for (int i = 0; i < userNumber.size(); i++) {
            if (userNumber == computerNumber) {
                this.strike = 3;
                break;
            }

            if (userNumber.get(i).equals(computerNumber.get(i))) {
                this.strike++;
            } else if (computerNumber.contains(userNumber.get(i))) {
                this.ball++;
            }
        }
    }

    public void resetBallStrike() {
        this.ball = 0;
        this.strike = 0;
    }

    public boolean isThreeStrike() {
        return this.strike == 3;
    }

    @Override
    public String toString() {
        String message = "";

        if (ball > 0) {
            message += this.ball + "볼 ";
        }

        if (strike > 0) {
            message += this.strike + "스트라이크";
        }

        if (ball + strike == 0) {
            message = "낫싱";
        }

        return message;
    }
}
