package baseball;

public class GameResult {
    private final int strikes;
    private final int balls;

    public GameResult(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }

    public boolean isGameWon() {
        return strikes == 3;
    }

    @Override
    public String toString() {
        if (strikes == 0 && balls == 0) {
            return "낫싱";
        }
        if (strikes == 0) {
            return balls + "볼";
        }
        if (balls == 0) {
            return strikes + "스트라이크";
        }
        return balls + "볼 " + strikes + "스트라이크";
    }
}

