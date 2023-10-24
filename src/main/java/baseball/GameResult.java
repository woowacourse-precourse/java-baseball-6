package baseball;

public class GameResult {
    private int strikes;
    private int balls;

    public GameResult(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public boolean isGameWon() {
        return strikes == 3;
    }

    @Override
    public String toString() {
        if (strikes == 0) {
            if (balls == 0) {
                return "낫싱";
            } else {
                return balls + "볼";
            }
        } else if (balls == 0) {
            return strikes + "스트라이크";
        } else {
            return balls + "볼 " + strikes + "스트라이크";
        }
    }
}