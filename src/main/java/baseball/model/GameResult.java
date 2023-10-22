package baseball.model;

public class GameResult {

    private final int balls;
    private final int strikes;

    public GameResult(int balls, int strikes) {
        this.balls = balls;
        this.strikes = strikes;
    }

    public boolean isCorrect(final int maxValue) {
        return strikes == maxValue;
    }

    public boolean isNothing() {
        return balls == 0 && strikes == 0;
    }

    @Override
    public String toString() {
        if (balls == 0) {
            return strikes + "스트라이크";
        }
        if (strikes == 0) {
            return balls + "볼";
        }
        return balls + "볼 " + strikes + "스트라이크";
    }
}
