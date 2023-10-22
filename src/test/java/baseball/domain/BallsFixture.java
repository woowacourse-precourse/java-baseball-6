package baseball.domain;

import baseball.domain.ball.Ball;
import baseball.domain.ball.Balls;

import java.util.ArrayList;
import java.util.List;

public class BallsFixture {
    private List<Ball> values;
    private int rounds = 3;

    private BallsFixture() {
        int minRange = 1;
        int maxRange = 9;

        values = new ArrayList<>();
        values.add(new Ball(4, minRange, maxRange));
        values.add(new Ball(2, minRange, maxRange));
        values.add(new Ball(5, minRange, maxRange));
    }

    public static BallsFixture fixture() {
        return new BallsFixture();
    }

    public BallsFixture name(List<Ball> values) {
        this.values = values;
        return this;
    }

    public BallsFixture rounds(int rounds) {
        this.rounds = rounds;
        return this;
    }

    public Balls build() {
        return new Balls(this.values, this.rounds);
    }
}
