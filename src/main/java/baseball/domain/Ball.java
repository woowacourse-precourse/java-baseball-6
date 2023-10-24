package baseball.domain;

import baseball.constant.Constant;

import java.util.Objects;

public class Ball {


    private final Integer ball;

    public Ball(Integer number) {
        this.ball = createBall(number);
    }

    private Integer createBall(Integer number) {
        validateRange(number);
        return number;
    }


    private void validateRange(Integer number) {
        if (!(Constant.START_RANGE <= number && number <= Constant.END_RANGE))
            throw new IllegalArgumentException("[error] 잘못된 숫자를 입력했습니다. 숫자 허용 범위는 1~9입니다.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball1 = (Ball) o;
        return Objects.equals(ball, ball1.ball);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball);
    }
}
