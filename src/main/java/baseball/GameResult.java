package baseball;

import java.util.Objects;
public class GameResult {
    private final int ball;
    private final int strike;

    public GameResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public boolean gameOver(){
        if(strike == 3) {
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

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