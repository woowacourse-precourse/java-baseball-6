package baseball.domain;

import java.util.List;

public class GameResult {

    private int strike;
    private int ball;
    private final String NOTHING_STR = "낫싱";
    private final String BALL_STR = "볼";
    private final String STRIKE_STR = "스트라이크";

    public void strikeOrBall(List<Integer> baseballNumbers, List<Integer> userInputNumbers) {
        this.strike = 0;
        this.ball = 0;

        for (int i = 0; i < userInputNumbers.size(); i++) {
            if (baseballNumbers.get(i) == userInputNumbers.get(i)) {
                this.strike++;
            } else if (baseballNumbers.contains(userInputNumbers.get(i))) {
                this.ball++;
            }
        }
    }

    @Override
    public String toString() {
        int strike = this.strike;
        int ball = this.ball;

        if (strike == 0 && ball == 0) {
            return NOTHING_STR;
        } else if (strike == 0) {
            return ball + BALL_STR;
        } else if (ball == 0) {
            return strike + STRIKE_STR;
        }

        return ball + BALL_STR + " " + strike + STRIKE_STR;
    }

    public boolean isWin() {
        if (this.strike == 3) return true;

        return false;
    }
}
