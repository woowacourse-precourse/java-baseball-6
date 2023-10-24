package baseball.game;

public class MatchResult {
    private final int ball;
    private final int strike;

    protected MatchResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(ball);
        result = 31 * result + Integer.hashCode(strike);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MatchResult result)) {
            return false;
        }
        return (result.ball == ball) && (result.strike == strike);
    }

    @Override
    public String toString() {
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }

        StringBuilder sb = new StringBuilder();
        if (ball > 0) {
            sb.append(ball).append("볼");
        }
        if (strike > 0) {
            sb.append(ball > 0 ? " " : "").append(strike).append("스트라이크");
        }

        return sb.toString();
    }
}
