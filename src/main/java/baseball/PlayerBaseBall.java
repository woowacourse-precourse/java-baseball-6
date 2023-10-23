package baseball;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerBaseBall {
    private List<Ball> balls;

    public PlayerBaseBall(String numbers) {
        this.balls = createBaseBall(numbers);
    }

    private List<Ball> createBaseBall(String numbers) {
        return Arrays.stream(numbers.split(""))
                .map(Ball::new)
                .collect(Collectors.toList());
    }

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(balls);
    }
}
