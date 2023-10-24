package baseball.domain.game;

import baseball.domain.ball.Ball;

import java.util.ArrayList;
import java.util.List;

public class BallMapper {

    public static List<Ball> mapFrom(List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();

        for (int index = 0; index < numbers.size(); index++) {
            balls.add(generateBall(numbers, index));
        }

        return balls;
    }

    private static Ball generateBall(List<Integer> numbers, int index) {
        return new Ball(numbers.get(index), index + 1);
    }
}
