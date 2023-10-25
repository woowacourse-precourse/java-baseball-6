package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractBalls implements Balls {

    private final List<Ball> balls;

    protected AbstractBalls(List<Ball> balls) {
        this.balls = balls;
    }

    // TODO ComputerBalls는 Integer를 통해 만들어질 수 있도록 개선하기
    protected static List<Ball> mapToBalls(String rawNumbers) {
        List<String> numbers = new ArrayList<>();
        for (char number : rawNumbers.toCharArray()) {
            numbers.add(String.valueOf(number));
        }

        return numbers.stream()
                .map(Ball::from)
                .toList();
    }

    @Override
    public List<Ball> balls() {
        return Collections.unmodifiableList(balls);
    }

    @Override
    public Ball ballAt(int index) {
        return balls.get(index);
    }

    @Override
    public String toString() {
        return "Balls{" +
                "balls=" + balls +
                '}';
    }

}
