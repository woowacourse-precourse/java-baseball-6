package baseball.domain.ball;

import baseball.domain.ball.Ball;
import java.util.Iterator;
import java.util.List;

public class Balls implements Iterable<Ball> {

    private List<Ball> balls;

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public int size() {
        return balls.size();
    }

    public boolean contains(Ball ball) {
        return balls.contains(ball);
    }

    public void add(Ball ball) {
        balls.add(ball);
    }

    @Override
    public Iterator<Ball> iterator() {
        return balls.iterator();
    }

    public Ball get(int index) {
        if (index >= 0 && index < balls.size()) {
            return balls.get(index);
        }
        throw new IllegalArgumentException();
    }
}
