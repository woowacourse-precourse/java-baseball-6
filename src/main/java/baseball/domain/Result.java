package baseball.domain;

import java.util.Objects;

public class Result {
    int ball;
    int strike;
    int out;

    public Result(int ball, int strike, int out) {
        this.ball = ball;
        this.strike = strike;
        this.out = out;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return ball == result.ball && strike == result.strike && out == result.out;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball, strike, out);
    }
}
