package baseball;

import java.util.Objects;

public class Result {
    private int strike;
    private int ball;

    public Result() {
        this.strike = 0;
        this.ball = 0;
    }

    //테스트에서 사용
    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    @Override
    public String toString() {
        if (strike + ball == 0) {
            return "낫싱";
        }
        StringBuilder result = new StringBuilder();
        if (ball != 0) {
            result.append(ball + "볼");
        }
        if (strike != 0) {
            if (!result.isEmpty()) {
                result.append(" ");
            }
            result.append(strike + "스트라이크");
        }

        return result.toString();
    }

    public void addStrike() {
        this.strike++;
    }

    public void addBall() {
        this.ball++;
    }

    public boolean isAnswer() {
        return this.strike == 3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Result result = (Result) o;
        return strike == result.strike && ball == result.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }
}