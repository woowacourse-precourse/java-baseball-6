package baseball;

import java.util.List;
import java.util.stream.Collectors;

public class Balls {
    private final List<Ball> ballList;

    public Balls(List<Integer> integerList) {
        this.ballList = integerList.stream()
                .map(Ball::new)
                .collect(Collectors.toList());
    }

    public List<Ball> getBallList() {
        return ballList;
    }
}
