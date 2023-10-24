package baseball;

public class GameResult {

    private final int strikes;
    private final int balls;

    public GameResult(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public boolean isGameWon() {
        return strikes == 3;
    }

    @Override
    public String toString() {
        if (strikes == 0 && balls == 0) {
            return "낫싱";
        }

        StringBuilder result = new StringBuilder();
        appendStrikes(result);
        appendBalls(result);

        return result.toString();
    }

    private void appendStrikes(StringBuilder result) {
        if (strikes > 0) {
            result.append(strikes).append("스트라이크");
        }
    }

    private void appendBalls(StringBuilder result) {
        if (balls > 0) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(balls).append("볼");
        }
    }

}
