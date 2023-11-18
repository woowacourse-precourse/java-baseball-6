package baseball.domain;

import java.util.Objects;

import static baseball.domain.Result.*;

public class GameResult {
    int ball;
    int strike;
    int out;

    public GameResult(int ball, int strike, int out) {
        this.ball = ball;
        this.strike = strike;
        this.out = out;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult result = (GameResult) o;
        return ball == result.ball && strike == result.strike && out == result.out;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball, strike, out);
    }

    @Override
    public String toString() {
        if (out == 3) {
            return NOTHING.getName();
        }

        String result = "";
        result += ballCountToStr();
        result += strikeCountToStr();

        return result;
    }

    private String ballCountToStr() {
        String result = "";

        if (ball > 0) {
            result += ball + BALL.getName();

            if (strike > 0) {
                result += " ";
            }
        }

        return result;
    }

    private String strikeCountToStr() {
        String result = "";

        if (strike > 0) {
            result += strike + STRIKE.getName();
        }

        return result;
    }
}
