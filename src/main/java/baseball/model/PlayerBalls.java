package baseball.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PlayerBalls {

    private static final int BALLS_MAXIMUM_SIZE = 3;

    private final List<Ball> balls = new ArrayList<>();

    public PlayerBalls(List<Integer> numbers) {
        validationNumbers(numbers);
        initBalls(numbers);
    }

    private void validationNumbers(List<Integer> numbers) {
        if (Set.copyOf(numbers).size() != BALLS_MAXIMUM_SIZE) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }

    private void initBalls(List<Integer> numbers) {
        balls.clear();

        for (int i = 0; i < numbers.size(); i++) {
            balls.add(new Ball(numbers.get(i), i + 1));
        }
    }
}
