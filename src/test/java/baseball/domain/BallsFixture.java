package baseball.domain;

import baseball.domain.ball.Ball;
import baseball.domain.ball.Balls;

import java.util.ArrayList;
import java.util.List;

public class BallsFixture {
    private List<Ball> values;

    private BallsFixture() {
        values = new ArrayList<>();
        values.add(new Ball(4));
        values.add(new Ball(2));
        values.add(new Ball(5));
    }

    public static BallsFixture fixture() {
        return new BallsFixture();
    }

    public BallsFixture values(List<Ball> values) {
        this.values = values;
        return this;
    }

    public Balls build() {
        return new Balls(this.values);
    }
}
