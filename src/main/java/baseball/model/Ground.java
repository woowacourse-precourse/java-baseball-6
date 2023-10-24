package baseball.model;

import java.util.Objects;

public final class Ground {
    private final int strike;
    private final int ball;

    private Ground(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static Ground of(int strike, int ball) {
        return new Ground(strike, ball);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ground ground = (Ground) o;
        return strike == ground.strike && ball == ground.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }


    /**
     * 스트라이크와 볼의 개수에 따라 결과를 반환한다.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (strike > 0 && ball > 0) {
            return stringBuilder.append(ball).append("볼 ").append(strike).append("스트라이크").toString();
        }
        if (strike > 0) {
            return stringBuilder.append(strike).append("스트라이크").toString();
        }
        if (ball > 0) {
            return stringBuilder.append(ball).append("볼").toString();
        }
        return "낫싱";
    }
}
