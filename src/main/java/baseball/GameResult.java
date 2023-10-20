package baseball;

import java.util.Objects;

public class GameResult {
    private final int strike;
    private final int ball;

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    @Override
    public String toString() {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        StringBuilder result = new StringBuilder();

        if (ball > 0) {
            result.append(ball).append("볼 ");
        }

        if (strike > 0) {
            result.append(strike).append("스트라이크");
        }

        return result.toString().trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GameResult that = (GameResult) o;

        return strike == that.strike && ball == that.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }
}
