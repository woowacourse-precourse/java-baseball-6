package baseball.domain;

import static baseball.constants.GameConstants.COUNT;

public class Game {
    private int strikes;
    private int balls;


    public Game(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public boolean isWin() {
        return strikes == COUNT;
    }

    public String getResultString() {
        if (isWin()) {
            return "3스트라이크";
        }

        String result = "";

        if (balls > 0) {
            result += balls + "볼 ";
        }
        if (strikes > 0) {
            result += strikes + "스트라이크 ";
        }

        if (result.isEmpty()) {
            return "낫싱";
        }

        return result.trim();
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }
}
